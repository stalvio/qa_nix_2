package ua.com.alevel.unit_7_patterns.entity;

import java.util.Date;

public class Worker {

        private String id;
        private String firstName;
        private String lastName;
        private Date birthDay;
        private String departmentId;
        private String email;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Date getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(Date birthDay) {
            this.birthDay = birthDay;
        }

        public String getDepartment() {
            return departmentId;
        }

        public void setDepartment(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public static Builder newWorker() {
            return new Worker().new Builder();
        }

        public class Builder {

            private Builder() {
            }

            public Builder setId(String id) {
                Worker.this.id = id;
                return this;
            }

            public Builder setFirstName(String firstName) {
                Worker.this.firstName = firstName;
                return this;
            }

            public Builder setLastName(String lastName) {
                Worker.this.lastName = lastName;
                return this;
            }

            public Builder setEmail(String email) {
                Worker.this.email = email;
                return this;
            }

            public Builder setBirthDay(Date birthDay) {
                Worker.this.birthDay = birthDay;
                return this;
            }

            public Builder setDepartment(String departmentId){
                Worker.this.departmentId = departmentId;
                return this;
            }

            public Worker build() {
                return Worker.this;
            }
        }
}

