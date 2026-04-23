package com.back;

public class Calc {
    static int m_idx = 0;
    static String m_str;

    public static int run(String str) {
        m_str = str.replace(" ", "");
        return parseBinomial();
    }

    private static int parseBinomial() {
        int n = parseExpr();

        while (m_idx < m_str.length()) {
            char c = m_str.charAt(m_idx);

            if (c == '+') {
                m_idx++;
                n += parseExpr();
            } else if (c == '-') {
                m_idx++;
                n -= parseExpr();
            } else {
                break;
            }
        }

        return n;
    }

    private static int parseExpr() {
        int n = parseNum();

        while (m_idx < m_str.length()) {
            char c = m_str.charAt(m_idx);

            if (c == '*') {
                m_idx++;
                n *= parseNum();
            } else if (c == '/') {
                m_idx++;
                n /= parseNum();
            } else {
                break;
            }
        }

        return n;
    }

    private static int parseNum() {
        char c = m_str.charAt(m_idx);

        if (c == '-') {
            m_idx++;
            return -parseNum();
        } else  if (c == '(') {
            m_idx++;
            int val = parseBinomial();
            m_idx++;
            return val;
        }

        int num = 0;
        while (m_idx < m_str.length()
                && Character.isDigit(m_str.charAt(m_idx))) {
            num = num * 10 + (m_str.charAt(m_idx++) - '0');
        }

        return num;
    }
}