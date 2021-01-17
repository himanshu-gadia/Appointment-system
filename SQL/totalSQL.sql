drop table hospital_login;
create table hospital_login(
id number(9),
name varchar2(10) not null,
username varchar2(12) not null unique,
password varchar2(7) not null,
rolltype varchar(15) not null,
constraint hospital_login_id primary key(id)
);
drop sequence hospital_login_seq;
create sequence hospital_login_seq
start with 1

--insert
--admin 
insert into hospital_login(id, name, username, password, rolltype)values(hospital_login_seq.nextVal, 'admin', 'admin', '1234', 'admin');
--reception
insert into hospital_login(id, name, username, password, rolltype)values(hospital_login_seq.nextVal, 'Reception1', 'reception1', '1234', 'receptionist');
--doctor
insert into hospital_login(id, name, username, password, rolltype)values(hospital_login_seq.nextVal, 'Doctor', 'doc1', '1234', 'doctor');

--end



drop table Patients_record;

create table Patients_record(
ID number(20),
NAME varchar2(25) not null,
FATHER_NAME varchar2(25) not null,
CONTACT number(10) not null,
CONTACT_SEC number(10),
DOB date not null,
GENDER varchar2(6) not null,
EMAIL varchar2(40) not null,
PINCODE number(8) not null,
constraint patients_id primary key(ID)
);

drop sequence patients_id_seq;
create sequence patients_id_seq
start with 100000


-- insert query

insert into Patients_record(ID, NAME ,FATHER_NAME,CONTACT,CONTACT_SEC,DOB,GENDER, EMAIL,PINCODE ) values ( patients_id_seq.nextval, 'Himanshu' , '' , 123456789, 987654321, to_date('11/02/2001','MM/DD/YYYY') , 'male' , 'ABC@XYZ.com' , 337765);

--end



drop table Doctors_record;
create table Doctors_record(
ID number(4),
REGD_NO varchar2(10) not null unique,
NAME varchar2(25) not null,
CONTACT number(10) not null,
GENDER varchar2(6) not null,
DOB date not null,
SPECIALISATION varchar(30) not null,
DESIGNATION varchar(30) not null,
constraint doctors_id primary key(ID)
);

drop sequence Doctors_id_seq;
create sequence Doctors_id_seq
start with 1000;

--inset query

insert into Doctors_record(ID,REGD_NO,NAME,CONTACT,GENDER, DOB, SPECIALISATION, DESIGNATION)values(Doctors_id_seq.nextval , ?,?,?,?,?,?,?)
--remember not to use ; at the end as it is invalid
--end

--start appointment

drop table Appointment_Table;
create table Appointment_Table(
REF_ID number(10),
P_ID number(10),
D_ID number(10),
A_DATE date,
A_TIME number(4),
constraint referance_id primary key(REF_ID),
constraint fk_patients_id_app foreign key(P_ID) references Patients_record(ID),
constraint fk_doctors_id_app foreign key(D_ID) references Doctors_record(ID)
);
drop sequence Appointment_seq;
create sequence Appointment_seq
start with 1;

insert into Appointment_Table(REF_ID, P_ID, D_ID, A_DATE, A_TIME)values(Appointment_seq.nextVal,?,?,?,?);
-- end appointment 

--fetching appointment
select * from appointment_table where d_id = 1000 and a_date> sysdate; 
--
drop table Appointment_Table;
drop table Doctors_record;
drop table Patients_record;

drop table medical_accessory;
create table medical_accesory(
refrId number(10),
name varchar2(20),
price float(10)
);
drop sequence medical_accessory;
create sequence medical_accessory
start with 10000;
insert into medical_accessory(refrId, name, price)values(medical_accessory.nextVal, 'paracetamol', 20.6);



