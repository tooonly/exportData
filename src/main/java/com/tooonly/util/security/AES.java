package com.tooonly.util.security;

import java.util.ArrayList;

public abstract class AES {
    public abstract byte[] encode(byte[] bysContent);
    public abstract String encode(String strText);
    public abstract byte[] decode(byte[] bysEncoded);
    public abstract String decode(String strEncoded);
    public static String[] splitString(String strSource, char chSeperator) {
        ArrayList alOutput = new ArrayList();
        StringBuilder strbString = new StringBuilder();

        for(int i = 0; i < strSource.length(); ++i) {
            char chChar = strSource.charAt(i);
            if (chChar == chSeperator) {
                alOutput.add(strbString.toString());
                strbString = new StringBuilder();
            } else {
                strbString.append(chChar);
            }
        }

        alOutput.add(strbString.toString());
        String[] strsOutput = new String[alOutput.size()];

        for(int i = 0; i < alOutput.size(); ++i) {
            strsOutput[i] = (String)alOutput.get(i);
        }

        return strsOutput;
    }
}
