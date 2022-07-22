package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int rowStart = 0;
        int columnStart = 0;
        int[][] spiral = new int[rows][columns];
        int x = rows * columns; //столбы * строки
        int rowEnd = rows - 1; //строки-1
        int columnsEnd = columns - 1; //столбы-1
        for (int i = 1; i <= x; i++) {
            int cs = columnStart;
            //Движение вправо
            while (cs <= columnsEnd){
                spiral[rowStart][cs] = i;
                i++;
                cs++;
            }
            rowStart++;
            if(rowStart > rowEnd){
                break;
            }
            int rs = rowStart;
            //Движение вниз
            while (rs <= rowEnd){
                spiral[rs][columnsEnd]=i;
                i++;
                rs++;
            }
            columnsEnd--;
            if (columnsEnd < columnStart){
                break;
            }
            cs = columnsEnd;
            //Движение влево
            while (cs >= columnStart){
                spiral[rowEnd][cs] = i;
                i++;
                cs--;
            }
            rowEnd--;
            if (rowEnd < rowStart){
                break;
            }
            rs = rowEnd;
            //Движение вверх
            while (rs >= rowStart){
                spiral[rs][columnStart] = i;
                i++;
                rs--;
            }
            columnStart++;
            if (columnStart > columnsEnd){
                break;
            }
            i--;
        }
return spiral;
    }
}
//        for (int i = 0; i < spiral.length; i++) {
//        for (int j = 0; j < spiral[i].length; j++) {
//            System.out.print(String.format("%4s", spiral[i][j]));
//        }
//        System.out.println();
//    }





