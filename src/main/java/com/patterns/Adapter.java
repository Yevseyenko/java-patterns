package com.patterns;

import java.io.FileNotFoundException;

public class Adapter {

    public static void main(String[] args) throws FileNotFoundException {
// example with inheritance
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();
        //example with composition
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Painting line");
    }

    void drawRasterSquare() {
        System.out.println("Painting square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics raster = new RasterGraphics();

    @Override
    public void drawSquare() {
        raster.drawRasterLine();
    }

    @Override
    public void drawLine() {
        raster.drawRasterSquare();
    }
}

