package com.data.structure.practice.sparseaArray;

import org.springframework.stereotype.Component;
import java.io.*;

/**
 * 采用二维数组实现 五子棋盘保存、复盘，二维数组有很多重复数0，替换成稀疏数组减少磁盘空间占用
 * 二维数组 -> 稀疏数组 -> 文件
 * 文件 -> 稀疏数组 -> 二维数组
 */
@Component
public class SparseArray {

    private int sparseArrRowNum = 0;

    public void main () throws IOException {
        // 生成二维数组
        int arr[][] = new int[5][5];
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (x == 1 && y == 4) {
                    arr[x][y] = 3;
                } else if (x == 2 && y == 2) {
                    arr[x][y] = 5;
                } else if (x == 4 && y == 3) {
                    arr[x][y] = 2;
                } else {
                    arr[x][y] = 0;
                }
            }
        }

        // 查看二维数组
        for (int[] row : arr) {
            for (int num : row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

        // 统计数量
        int sum = 0;
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (arr[y][x] != 0) {
                    sum++;
                }
            }
        }

        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 5;
        sparseArr[0][1] = 5;
        int count = 0;
        int row = 0;

        // 创建稀疏数组
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (arr[y][x] != 0) {
                    sparseArr[0][2] = ++count;
                    row++;
                    sparseArr[row][0] = y;
                    sparseArr[row][1] = x;
                    sparseArr[row][2] = arr[y][x];
                }
            }
        }

        // 查看稀疏数组
        for (int[] row2 : sparseArr) {
            for (int num : row2) {
                System.out.printf("%d\t", num);
            }
            sparseArrRowNum++;
            System.out.println();
        }

        // 创建文件
        File file = new File("D:\\Temp\\data");
        if (!file.exists()) {
            file.createNewFile();
        }

        // 稀疏写入文件
        FileWriter writer = new FileWriter(file);
        for (int[] row2 : sparseArr) {
            for (int num : row2) {
                writer.write(num + "\t");
            }
            writer.write("\r\n");
        }
        writer.close();

        // 读取文件,存储为稀疏数组
        String line;
        int rouNum = 0;
        int [][] sparseArr2 = new int[sparseArrRowNum][3];

        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            String[] cols = line.split("\t");
            for (int y = 0; y < 3; y++) {
                sparseArr2[rouNum][y] = Integer.parseInt(cols[y]);
            }
            rouNum++;
        }
        br.close();

        // 转为二维数组
        int [][] arr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        for (int y = 1; y < sparseArr2.length; y++) {
            arr2[sparseArr2[y][0]][sparseArr2[y][1]] = sparseArr2[y][2];
        }

        // 查看二维数组
        System.out.println("这是二维数组：");
        for (int[] row2 : arr) {
            for (int num : row2) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
    }
}
