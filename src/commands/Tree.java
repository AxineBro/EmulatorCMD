package commands;

import basicFiles.Dir;
import basicFiles.SystemElements;

public class Tree {
	public static String completTree(String prefix, boolean isLast, basicFiles.Dir currentDirectory) {
		StringBuilder resultTree = new StringBuilder();
		resultTree.append(prefix + (isLast ? "└── " : "├── ") + currentDirectory.getSystemElementsName()+"\r\n");
		for (int i = 0; i < currentDirectory.getComponentsDir().size(); i++) {
            SystemElements element = currentDirectory.getComponentsDir().get(i);
            boolean lastElement = (i == currentDirectory.getComponentsDir().size() - 1);
            String newPrefix = prefix + (isLast ? "    " : "│   ");

            if (element instanceof Dir) {
            	resultTree.append(completTree(newPrefix, lastElement,(Dir) element));
            } else {
            	resultTree.append(newPrefix + (lastElement ? "└── " : "├── ") + element.getSystemElementsName()+"\r\n");
            }
        }
		return resultTree.toString();
	}
}
