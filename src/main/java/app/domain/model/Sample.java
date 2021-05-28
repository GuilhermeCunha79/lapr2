package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.output.OutputException;

import java.util.ArrayList;
import java.util.List;


public class Sample {
    private List<Sample> sampleList = new ArrayList<>();

    public Sample(ArrayList sampleList) {
        this.sampleList = new ArrayList<>(sampleList);
    }





}

