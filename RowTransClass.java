package rowtransposition;


public class RowTransClass {
    
    public static int getrow(String text, String key) {
        int row;
        if (((text.length()) % (key.length())) == 0) {
            row = text.length() / key.length();
        } else
        {
            int rowt = text.length() ;
            while ((rowt % (key.length()) != 0)) {
                rowt = rowt + 1;
            }
            row = rowt / key.length();
        }
        return row;
    }
    

    public static String Encrypt(String pt, String key) {
        String text=removewhitespace(pt);
        int row = getrow(text, key);
        int colum = key.length();
        int indexcolum;
        String ciphertext[][] = new String[row][colum];
        String plaintext[][] = matrix2d(text, key);
        //int countc=0;
        for (int i = 0; i < key.length(); i++) {
            indexcolum = Integer.parseInt(Character.toString(key.charAt(i)));
            for (int j = 0; j < row ; j++) {
                ciphertext[j][i]=plaintext[j][indexcolum-1];
            }
        }
        String ct=Convert2DArrayToString(ciphertext,row,colum);
        return ct;
    }

    public static String[][] matrix2d(String aftreremospace, String key) {
        int row = getrow(aftreremospace, key);
        int colum = key.length();
        String string2d[][] = new String[row][colum];
        int p = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < colum; c++) {
                if (p < aftreremospace.length()) {
                    string2d[r][c] = Character.toString(aftreremospace.charAt(p));
                    p = p + 1;
                } else {
                    string2d[r][c] = "-";
                }
            }
        }
        return string2d;
    }

    public static String Decrypt(String ct, String key){
        String text=removewhitespace(ct);
        int row = getrow(text, key);
        int colum = key.length();
        int indexcolum;
        String plaintext[][] = new String[row][colum];
        String ciphertext[][] = matrix2d(text, key);
        
        for (int i = 0; i < key.length(); i++) {
            indexcolum = Integer.parseInt(Character.toString(key.charAt(i)));
            for (int j = 0; j < row ; j++) {
                plaintext[j][indexcolum-1]=ciphertext[j][i];
            }
        }
        String pt=Convert2DArrayToString(plaintext,row,colum);
        return pt;
    }
    
    public static String Convert2DArrayToString(String[][] args,int row, int col) {
        String str="";
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                str=str+args[i][j];
            } 
        }
        return str;
    }
    
    public static String removewhitespace(String str) {
        String text = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                text = text + str.charAt(i);
            }
        }
        return text;
    }
    
}
