package tech.chenxing;

import lombok.Data;

/**
 * 功能说明：
 *
 * @author fengqingyang
 * @return
 * @date [2020年03月29日上午12:24]
 */
@Data
public class SubMenu {
    private String[] arr=new String[1];
    public SubMenu(String first,String second){
        arr[0]=first;
        arr[1]=second;
    }
}
