package com.example.accessingdatamysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity // This tells Hibernate to make a table out of this class
public class Regions {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="REGION_ID")
        private Integer id;

        private String regionName;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getRegionName() {
                return regionName;
        }

        public void setRegionName(String regionName) {
                this.regionName = regionName;
        }

}
