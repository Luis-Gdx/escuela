/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis G
 */
public class User {

    private int id, permisoId, notificationId = -1;
    private String nombre, email;
    private boolean admin, c, r, u, d, online = false;

    public User(int id, String nombre, int permisoId) {
        this.id = id;
        this.permisoId = permisoId;
        this.nombre = nombre;
        admin = false;
        c = false;
        r = false;
        u = false;
        d = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }

    public boolean isU() {
        return u;
    }

    public void setU(boolean u) {
        this.u = u;
    }

    public boolean isD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(int permisoId) {
        this.permisoId = permisoId;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

}
