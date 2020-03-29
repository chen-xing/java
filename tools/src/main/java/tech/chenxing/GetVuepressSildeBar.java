package tech.chenxing;


import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 功能说明：
 *
 * @author fengqingyang
 * @return
 * @date [2020年03月28日上午17:24]
 */
public class GetVuepressSildeBar {

  private static String excludePath=".vuepress";
  private static String dir = "D:\\chenxing\\vuepress\\docs";

  private static String execludeFile="README.md";

  public static void main(String[] args) {
    List<Menu> list=getMennu(dir);
    System.out.println(new Gson().toJson(list));
  }


  private static List<List<String>> getSubMennu(String subdir){
    List<List<String>> listSub=Lists.newArrayList();
    File[] listArr= FileUtil.ls(subdir);

    Arrays.stream(listArr).forEach(x->{
      String path=x.getAbsolutePath();
      if(!path.contains(execludeFile)){
          List<String> subList=Lists.newArrayList();
          subList.add(path.replace(dir,"").replace("\\","/").replace(".md",""));
          subList.add(x.getName().replace(".md",""));
          listSub.add(subList);
      }
    });
    return listSub;
  }

  private static List<Menu> getMennu(String dir){
    List<Menu> listSub= Lists.newArrayList();
    File[] fileList= FileUtil.ls(dir);

    Arrays.stream(fileList)
        .forEach(
            x -> {
              String path = x.getAbsolutePath();
              if (x.isDirectory()) {
                if (!x.getName().equals(excludePath)) {
                  Menu subMenu = new Menu();
                  subMenu.setTitle(x.getName());
                  subMenu.setCollapsable(false);
                  subMenu.setChildren(getSubMennu(path));
                  listSub.add(subMenu);
                }
              }
            });
    return listSub;
  }
}
