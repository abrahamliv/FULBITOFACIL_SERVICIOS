/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upc.iluminados.util;

/**
 *
 * @author cdiaz
 */
public class StringUtils {

    public static String trim(String param) {
        return null == param ? null : param.trim();
    }

    public static boolean isEmpty(String param) {
        return null == param || 0 == param.length() ? true : false;
    }

}
