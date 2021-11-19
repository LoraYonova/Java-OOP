package SOLID.impl.factories;

import SOLID.impl.layouts.SimpleLayout;
import SOLID.impl.layouts.XmlLayout;
import SOLID.interfaces.Factory;
import SOLID.interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String input) {
        Layout layout = null;

        if(input.equals("SimpleLayout")){
            layout = new SimpleLayout();
        } else if (input.equals("XmlLayout")){
            layout = new XmlLayout();
        }

        return layout;
    }
}
