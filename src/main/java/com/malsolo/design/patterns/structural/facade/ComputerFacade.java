package com.malsolo.design.patterns.structural.facade;

public class ComputerFacade {

    private static final long BOOT_ADDRESS = 1000;

    private static final int SECTOR_SIZE = 512;

    private static final long BOOT_SECTOR = 0;

    private Cpu processor;

    private Memory ram;

    private HardDrive hd;

    public ComputerFacade() {
        this.processor = new Cpu();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.freeze();
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }

}
