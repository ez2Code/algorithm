package com.algorithm;

/**
 * Created by Levy on 2017/1/24.
 */
public class RegMatcher {
    public boolean isMatch(String s, String p) {
        return matcher(s,p);
    }
    private boolean matcher(String s,String org){
        if (s.equals(org)){
            return true;
        }
        if(org.equals("")&&s.length()>0){
            return false;
        }
        if(org.length()<2){
            return s.length()==1&&match(s,org);
        }
        if(org.charAt(1)!='*'){
            try {
                return match(s.substring(0,1),org.substring(0,1))&&matcher(s.substring(1),org.substring(1));
            }catch (Exception e){
                return false;
            }
        }else {
            if(s.equals("")){
                return matcher("",org.substring(2));
            }
            boolean isMatch = false;
            int cache = 0;
            try {
                while(match(s.substring(cache,cache+1),org.substring(0,1))){
                    cache++;
                }
            }catch (Exception e){
                isMatch = matcher("",org.substring(2));
            }
            while(!isMatch&&cache>=0){
                isMatch = matcher(s.substring(cache),org.substring(2));
                cache--;
            }
            return isMatch;
        }
    }
    private boolean match(String s,String org){
        switch (org){
            case ".":return true;
            default:return s.equals(org);
        }
    }

    public static void main(String args[]){
        String s = "aa";
        String reg = ".";
        System.out.println(new RegMatcher().isMatch(s,reg));
    }
}
