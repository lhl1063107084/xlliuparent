package test;


import org.springframework.util.StringUtils;

/**
 * @author liuxiaolun
 * @Description:
 * @date 2018-11-08 10:10:33
 **/
public class StringTest {

    public static void main(String a[]) {
        System.out.println(isSymmetry("[}{]"));
    }

    /**
     * "{","}","[","]","(",")" 组成的字符串,要求对称返回true,否则返回false
     * 1.length必须大于0且是偶数才能对称
     * 2.假设对称,从中间切开取右侧循环进行成对替换成空串,如果对称最终长度为0,否则不对称。
     */
    public static Boolean isSymmetry(String str) {
        if (StringUtils.isEmpty(str) || str.length() % 2 != 0) {
            return false;
        }

        int length = str.length();
        int middle = str.length() / 2;
        char[] chars = str.toCharArray();
        for (int i = middle; i <= length - 1; i++) {
            char aChar = chars[i];
            //判断aChar是哪种符号,并找出其对称的组合。
            String symmetry = getSymmetry(aChar);
            if (StringUtils.isEmpty(symmetry)) {
                throw new RuntimeException("传入字符非法");
            }
            str = str.replace(symmetry, "");
        }
        return str.length() > 0 ? false : true;
    }


    /**
     * @param aChar 字符
     * @return
     */
    public static String getSymmetry(char aChar) {
        if (aChar == '}') {
            return "{}";
        }
        if (aChar == '{') {
            return "}{";
        }
        if (aChar == ']') {
            return "[]";
        }
        if (aChar == '[') {
            return "][";
        }
        if (aChar == ')') {
            return "()";
        }
        if (aChar == '(') {
            return ")(";
        }
        return null;
    }


}
