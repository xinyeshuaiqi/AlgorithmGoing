package pers.wmx.interview;

/**
 * @author wmx
 * @date 2020-03-09
 */
public class Main3 {
    public static void main(String[] args) {
        String test = "1001,'Jack',jack@xxx.com";
        String rst = transfer(test);
        System.out.println(rst);
    }

    public static String transfer(String str){

        StringBuffer stringBuffer = new StringBuffer();
        String[] strs = str.split(",");
        for(int i = 0; i< strs.length; i++){
            String tempStr = strs[i];
            if(tempStr.contains("'")){
                stringBuffer.append(strs[i]);
                if(i != strs.length -1){
                    stringBuffer.append(",");
                }
                continue;
            }

            stringBuffer.append("'");
            stringBuffer.append(tempStr);
            stringBuffer.append("'");
            if(i != strs.length -1){
                stringBuffer.append(",");
            }
        }

        return stringBuffer.toString();

    }

}
