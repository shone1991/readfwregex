/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfilewithregex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author LapasovFG.VCRP
 */
public class NewClass {

    public static void main(String[] args) {
        Map<Character, List<String>> group = new HashMap();
        List<String> strings = Arrays.asList("one", "two", "three", "four");
        String joined=strings.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("result: "+joined);
        ArrayList<String> anotherList = new ArrayList(strings);
//        for (String string : anotherList) {
////            System.out.println(""+string);
//            Character firstCharacter = string.charAt(0);
//
//            if (group.containsKey(firstCharacter)) {
//                group.get(firstCharacter).add(string);
//            } else {
//                group.put(firstCharacter, Arrays.asList(string));
//            }
//        }
        System.out.println("len: "+group.size());
    }

}
