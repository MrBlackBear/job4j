package ru.job4j.jdbc;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

public class XmlEntries {
    @XmlRootElement
    public static class Entries {
        private List<Entry> entry;

        public Entries() {
        }

        public Entries(List<Entry> entry) {
            this.entry = entry;
        }

        @XmlElement
        public List<Entry> getEntry() {
            return entry;
        }


        public void setEntry(List<Entry> entries) {
            this.entry = entry;
        }
    }

    @XmlRootElement
    public static class Entry {
        private int field;

        public Entry() {
        }

        public Entry(int field) {
            this.field = field;
        }

        @XmlElement
        public int getField() {
            return field;
        }

        public void setField(int field) {
            this.field = field;
        }
    }

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                new Entries(Arrays.asList(new Entry(1), new Entry(2))),
                System.out
        );
    }
}
