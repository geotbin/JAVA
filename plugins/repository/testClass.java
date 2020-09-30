package plugins;

import plugin.Plugin;





public class testClass implements Plugin
{
  public ToUpperCase() {}
  
  public String transform(String s)
  {
    return "Hello";
  }
  


  public String getLabel()
  {
    return "to upper case";
  }
  


  public String helpMessage()
  {
    return "Transform all the letters to upper case";
  }
}