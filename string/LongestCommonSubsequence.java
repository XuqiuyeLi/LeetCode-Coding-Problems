 static int commonChild(String s1, String s2) {
        int[][] common = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    common[i+1][j+1] = common[i][j] + 1;
                } else {
                    common[i+1][j+1] = Math.max(common[i+1][j], common[i][j+1]);
                }
            }
        }
        return common[s1.length()][s2.length()];

    }