package com.company;

public class PrintFormat {
    /*
    Các thuộc tính, phuong thức thuộc mức đối tượng (ko static)
    -> chỉ sử dụng được khi đã khởi tạo instance

    các thuộc tính, phương thức thuộc mức lớp (static)
    -> có thẻ sử dụng mà không cẩn phải khởi tạo instance
    * */

    public static final String HEAD_FORMAT =
            "|%-10s |%-20s |%-15s |%-25s |%-10d |%-10d |%-10s |%-20s";

    public void drawLine(int num){
        for(int i = 0; i < num; i++){
            System.out.print("-");
        }
    }

}
