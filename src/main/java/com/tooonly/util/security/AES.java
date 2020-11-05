package com.tooonly.util.security;

import java.util.ArrayList;

abstract class AES {
    abstract byte[] encode(byte[] bysContent);
    abstract String encode(String strText);
    abstract byte[] decode(byte[] bysEncoded);
    abstract String decode(String strEncoded);
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
