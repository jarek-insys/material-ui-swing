/**
 * MIT License
 *
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.table;

import mdlaf.components.textfield.MaterialComponentField;
import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.utils.MaterialConstants;

import javax.swing.*;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialTableCellEditor extends DefaultCellEditor {

    private static JTextField init() {
        JTextField textField = new JTextField();
        return init(textField);
    }

    private static JTextField init(JTextField textField) {
        MaterialConstants.TextComponent lineStyle = (MaterialConstants.TextComponent)UIManager.get("Table[TextField].lineStyleType");
        if(lineStyle == null)
            lineStyle = MaterialConstants.TextComponent.TEXT_FIELD_STYLE_NONE; 
        textField.setUI(new MaterialTextFieldUI(lineStyle));
        return textField;
    }

    public MaterialTableCellEditor() {
        super(init());
    }

    public MaterialTableCellEditor(JComboBox comboBox) {
        super(comboBox);
    }

    public MaterialTableCellEditor(JCheckBox checkBox) {
        super(checkBox);
    }

    public MaterialTableCellEditor(JTextField textField) {
        super(init(textField));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JComponent component = (JComponent) super.getTableCellEditorComponent(table, value, isSelected, row, column);
        //OLD version code restored for JMars version
        /*
        boolean alternativeRow = UIManager.getBoolean("Table.alternateRowColor");
        Color alternativeRowColor = UIManager.getColor("Table.alternateRowBackground");
        Color normalColor = UIManager.getColor("Table.background");
        if(alternativeRow){
            if(!isSelected){
                if(row%2 == 1) {
                    component.setBackground(alternativeRowColor);
                }else{
                    component.setBackground(normalColor);
                }
            }
        }*/
        return component;
    }
}
