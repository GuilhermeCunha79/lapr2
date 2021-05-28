package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.output.OutputException;


public class Sample {

    private final Barcode barcode;

    public Sample(Barcode barcode) {
        this.barcode =barcode;
    }
}

