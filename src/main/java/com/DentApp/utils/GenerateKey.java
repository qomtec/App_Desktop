package com.DentApp.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class GenerateKey {
    private static FirebaseDatabase db;

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String key, String iv, String cleartext) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(cleartext.getBytes());
        return new String(encodeBase64(encrypted));
    }
    public static void main(String[] args) {
        try {
            //fffb1c4b321f9caafe97608b69b70c3d
            //fffb1c4b321f9caafe97608b69b70c3d
            //fffb1c4b321f9caafe97608b69b70c3d
            String email = "123456";//valores
            String encriptado = Utilidades.Encriptar(email);
            System.out.println(encriptado);
            String desencriptado = Utilidades.Desencriptar(encriptado);
            System.out.println(desencriptado);

            /*String resp = GenerateKey.encrypt("0123456789abcdef","4194374941943749",email);
            Usuario usuario = new Usuario();
            usuario.setUsuario(email);
            usuario.setToken(resp);
            usuario.setClave(GenerateKey.encrypt("0123456789abcdef","4194374941943749","123456"));
            guardarUsuario(usuario);*/
            //verificarUsuario(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void inicializar(){
        try {
            FileInputStream serviceAccount = new FileInputStream("./src/main/token.json");
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://mi-proyecto-123456.firebaseio.com/")
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(firebaseOptions);
            db = FirebaseDatabase.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void guardarUsuario(Usuario obj){
        if (obj != null){
            inicializar();
            try {
                DatabaseReference tbl = db.getReference("/tbl_Usuario");
                DatabaseReference  child = tbl.child(obj.getToken().substring(0,20));
                CountDownLatch transaction = new CountDownLatch(1);
                child.setValue(obj, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError error, DatabaseReference ref) {
                        System.out.println("Registro creado!");
                        transaction.countDown();
                    }
                });
                transaction.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private static int verificarUsuario(String email){
        final int resp = 0;
        inicializar();
        DatabaseReference tbl = db.getReference("/tbl_Usuario");
        try {
            String valor = GenerateKey.encrypt("0123456789abcdef","4194374941943749",email).substring(0,20);
            DatabaseReference  child = tbl.child(valor);
            CountDownLatch transaccion = new CountDownLatch(1);
            child.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    transaccion.countDown();
                    Usuario usuario = snapshot.getValue(Usuario.class);
                    System.out.println(usuario);
                }

                @Override
                public void onCancelled(DatabaseError error) {

                }
            });
            transaccion.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}

