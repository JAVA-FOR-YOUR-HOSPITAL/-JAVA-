package Hostpital_System_Model;

import java.util.ArrayList;

public interface ILookUp<T> {
	ArrayList<T> showList();
	ArrayList<T> partSearch(String name);
}
