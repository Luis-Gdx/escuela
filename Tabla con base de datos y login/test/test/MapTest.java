/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Luis G
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Object, Object> map = new TreeMap<Object, Object>();
        map.put("Nombre", "Luis");
        map.put("Nombre", "Gerardo");
        map.put("Nombre", ":v");
        System.out.println(map.size());
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get("Nombre"));
        }
        //System.out.println(map.get("Nombre"));
    }
}
