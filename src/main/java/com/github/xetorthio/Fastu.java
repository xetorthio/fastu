package com.github.xetorthio;

public class Fastu {
    public static String decode(byte[] data) {
        char[] chars = new char[data.length];
        int len = 0;
        int offset = 0;
        while (offset < data.length) {
            if ((data[offset] & 0x80) == 0) {
                // 0xxxxxxx - it is an ASCII char, so copy it exactly as it is
                chars[len] = (char) data[offset];
                len++;
                offset++;
            } else {
                int size = 0;
                int uc = 0;
                if ((data[offset] & 0xE0) == 0xC0) {
                    size = 1;
                    uc = (int) (data[offset] & 0x1F);
                } else if ((data[offset] & 0xF0) == 0xE0) {
                    size = 2;
                    uc = (int) (data[offset] & 0x0F);
                } else if ((data[offset] & 0xF8) == 0xF0) {
                    size = 3;
                    uc = (int) (data[offset] & 0x07);
                } else if ((data[offset] & 0xFC) == 0xF8) {
                    size = 4;
                    uc = (int) (data[offset] & 0x03);
                } else if ((data[offset] & 0xFE) == 0xFC) {
                    size = 5;
                    uc = (int) (data[offset] & 0x01);
                }
                ++offset;
                int limit = offset + size;
                for (; offset < limit; offset++) {
                    uc <<= 6;
                    uc |= (int) (data[offset] & 0x3F);
                }

                len = toChars(uc, chars, len);
            }
        }
        return new String(chars, 0, len);
    }

    public static int toChars(int codePoint, char[] dst, int index) {
        if (codePoint < 0 || codePoint > Character.MAX_CODE_POINT) {
            throw new IllegalArgumentException();
        }
        if (codePoint < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
            dst[index] = (char) codePoint;
            return ++index;
        }
        int offset = codePoint - Character.MIN_SUPPLEMENTARY_CODE_POINT;
        dst[index + 1] = (char) ((offset & 0x3ff) + Character.MIN_LOW_SURROGATE);
        dst[index] = (char) ((offset >>> 10) + Character.MIN_HIGH_SURROGATE);
        return index + 2;
    }
}
