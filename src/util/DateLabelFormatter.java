package util;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException{
        return simpleDateFormat.parse(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if(value != null){
            Calendar cal = (Calendar) value;
            return  simpleDateFormat.format(cal.getTime());
        }
        return null;
    }


}
