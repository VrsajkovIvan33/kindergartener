INSERT INTO institution (iid, iname, iaddr, iphono, ifullp, ipartp, version) VALUES (NEXTVAL('institution_iid_seq'), 'Cika Jova Zmaj', 'Mite Radujkova 5, Ada', '024/851-131', 50000, 35000, 1);

INSERT INTO education (eid, ename, version) VALUES (NEXTVAL('education_eid_seq'), 'Neobrazovan', 1);
INSERT INTO education (eid, ename, version) VALUES (NEXTVAL('education_eid_seq'), 'Osnovna škola', 1);
INSERT INTO education (eid, ename, version) VALUES (NEXTVAL('education_eid_seq'), 'Srednja škola', 1);
INSERT INTO education (eid, ename, version) VALUES (NEXTVAL('education_eid_seq'), 'Viša škola', 1);
INSERT INTO education (eid, ename, version) VALUES (NEXTVAL('education_eid_seq'), 'Akademske studije', 1);
INSERT INTO education (eid, ename, version) VALUES (NEXTVAL('education_eid_seq'), 'Master studije', 1);
INSERT INTO education (eid, ename, version) VALUES (NEXTVAL('education_eid_seq'), 'Doktorske studije', 1);

INSERT INTO shift (shid, shname, shstart, shend, version) VALUES (NEXTVAL('shift_shid_seq'), 'Celodnevna', '05:30', '15:30', 1);
INSERT INTO shift (shid, shname, shstart, shend, version) VALUES (NEXTVAL('shift_shid_seq'), 'Prepodnevna', '07:00', '12:00', 1);
INSERT INTO shift (shid, shname, shstart, shend, version) VALUES (NEXTVAL('shift_shid_seq'), 'Poslepodnevna', '12:00', '17:00', 1);

INSERT INTO worktype (wtid, wtname, wthours, wtmeals, version) VALUES (NEXTVAL('worktype_wtid_seq'), 'Obdaniste', 10, 2, 1);
INSERT INTO worktype (wtid, wtname, wthours, wtmeals, version) VALUES (NEXTVAL('worktype_wtid_seq'), 'Zabaviste', 5, 1, 1);

INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 2, 3, 1, 1, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 2, 4, 2, 1, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 2, 4, 2, 2, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 2, 5, 3, 1, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 2, 5, 3, 2, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 2, 5, 3, 3, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 1, 4, 3, 1, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 1, 4, 3, 2, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 1, 4, 3, 3, false, false, 1);
INSERT INTO category (ctgid, ctgparno, ctgfammemno, ctgchno, ctgorno, ctgspecnd, ctgdef, version) VALUES (NEXTVAL('category_ctgid_seq'), 0, 2, 1, 1, false, true, 1);

INSERT INTO agegroup (agid, agname, agage, version) VALUES (NEXTVAL('agegroup_agid_seq'), 'Trogodisnjaci', 3, 1);
INSERT INTO agegroup (agid, agname, agage, version) VALUES (NEXTVAL('agegroup_agid_seq'), 'Cetvorogodisnjaci', 4, 1);
INSERT INTO agegroup (agid, agname, agage, version) VALUES (NEXTVAL('agegroup_agid_seq'), 'Petogodisnjaci', 5, 1);
INSERT INTO agegroup (agid, agname, agage, version) VALUES (NEXTVAL('agegroup_agid_seq'), 'Sestogodisnjaci', 6, 1);

INSERT INTO nativelanguage (lid, lname, version) VALUES (NEXTVAL('language_lid_seq'), 'Srpski', 1);
INSERT INTO nativelanguage (lid, lname, version) VALUES (NEXTVAL('language_lid_seq'), 'Madjarski', 1);

INSERT INTO appuser (uid, uusrname, upword, uname, usname, iid, utype, eid, version) VALUES (NEXTVAL('appuser_uid_seq'), 'Admin', 'Admin', 'Random', 'Adminovski', 1, 'ADMIN', null, 1);
INSERT INTO appuser (uid, uusrname, upword, uname, usname, iid, utype, eid, version) VALUES (NEXTVAL('appuser_uid_seq'), 'Marko', 'Marko', 'Marko', 'Markovic', 1, 'PARENT', 5, 1);
INSERT INTO appuser (uid, uusrname, upword, uname, usname, iid, utype, eid, version) VALUES (NEXTVAL('appuser_uid_seq'), 'Milica', 'Milica', 'Milica', 'Markovic', 1, 'PARENT', 6, 1);
INSERT INTO appuser (uid, uusrname, upword, uname, usname, iid, utype, eid, version) VALUES (NEXTVAL('appuser_uid_seq'), 'Petar', 'Petar', 'Petar', 'Petrovic', 1, 'PARENT', 4, 1);
INSERT INTO appuser (uid, uusrname, upword, uname, usname, iid, utype, eid, version) VALUES (NEXTVAL('appuser_uid_seq'), 'Jasmina', 'Jasmina', 'Jasmina', 'Petrovic', 1, 'PARENT', 4, 1);
INSERT INTO appuser (uid, uusrname, upword, uname, usname, iid, utype, eid, version) VALUES (NEXTVAL('appuser_uid_seq'), 'Leposava', 'Leposava', 'Leposava', 'Dobrilovic', 1, 'TEACHER', 4, 1);
INSERT INTO appuser (uid, uusrname, upword, uname, usname, iid, utype, eid, version) VALUES (NEXTVAL('appuser_uid_seq'), 'Mira', 'NajboljaMama', 'Mirjana', 'Vrsajkov', 1, 'ACCOUNTANT', 4, 1);

INSERT INTO building (bid, bname, baddr, bphono, iid, version) VALUES (NEXTVAL('building_bid_seq'), 'Glavna', 'Mite Radujkova 5, Ada', '024/851-131', 1, 1);

INSERT INTO daycaregroup (gid, bid, shid, wtid, version) VALUES (NEXTVAL('daycaregroup_gid_seq'), 1, 1, 1, 1);

INSERT INTO grouplanguage (gid, lid) VALUES (1, 1);

INSERT INTO supportedgroup (sgid, agid, gid, version) VALUES (NEXTVAL('supportedgroup_sgid_seq'), 3, 1, 1);
INSERT INTO supportedgroup (sgid, agid, gid, version) VALUES (NEXTVAL('supportedgroup_sgid_seq'), 4, 1, 1);

INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 1, 1, 40, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 2, 1, 35, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 3, 1, 25, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 4, 1, 30, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 5, 1, 20, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 6, 1, 10, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 7, 1, 10, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 8, 1, 0, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 9, 1, 0, 1);
INSERT INTO pricelist (pid, pfdate, pudate, ctgid, iid, pperc, version) VALUES (NEXTVAL('pricelist_pid_seq'), TO_DATE('01.08.2016.', 'DD.MM.YYYY.'), null, 10, 1, 0, 1);

INSERT INTO teacher (uid, gid) VALUES (6, 1);

INSERT INTO child (cid, cname, csname, cdateob, cplaceob, cjmgb, caddress, cphono, ctgid, par1id, par2id, agid, lid, sgid, iid, version) VALUES (NEXTVAL('child_cid_seq'), 'Kristina', 'Markovic', TO_DATE('02.02.2011.', 'DD.MM.YYYY.'), 'Senta', '0202011820431', 'Doza Djerdja 11, Ada', '024/853-071', 2, 3, 2, 4, 1, 2, 1, 1);
INSERT INTO child (cid, cname, csname, cdateob, cplaceob, cjmgb, caddress, cphono, ctgid, par1id, par2id, agid, lid, sgid, iid, version) VALUES (NEXTVAL('child_cid_seq'), 'Stevan', 'Markovic', TO_DATE('14.07.2012.', 'DD.MM.YYYY.'), 'Senta', '1407012820223', 'Doza Djerdja 11, Ada', '024/853-071', 3, 3, 2, 3, 1, 1, 1, 1);
INSERT INTO child (cid, cname, csname, cdateob, cplaceob, cjmgb, caddress, cphono, ctgid, par1id, par2id, agid, lid, sgid, iid, version) VALUES (NEXTVAL('child_cid_seq'), 'Jovan', 'Petrovic', TO_DATE('24.04.2012.', 'DD.MM.YYYY.'), 'Senta', '2404012820113', 'Nikole Tesle 31, Ada', '024/852-593', 5, 5, 4, 3, 1, 1, 1, 1);

INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('03.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('04.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('05.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('06.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('07.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('10.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('11.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('12.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('13.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('18.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('19.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('20.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('21.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('24.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('25.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('26.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('27.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('28.04.2017', 'DD.MM.YYYY.'), 1, true, null, 1);

INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('03.04.2017', 'DD.MM.YYYY.'), 2, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('04.04.2017', 'DD.MM.YYYY.'), 2, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('05.04.2017', 'DD.MM.YYYY.'), 2, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('06.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('07.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('10.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('11.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('12.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('13.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('18.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('19.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('20.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('21.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('24.04.2017', 'DD.MM.YYYY.'), 2, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('25.04.2017', 'DD.MM.YYYY.'), 2, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('26.04.2017', 'DD.MM.YYYY.'), 2, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('27.04.2017', 'DD.MM.YYYY.'), 2, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('28.04.2017', 'DD.MM.YYYY.'), 2, false, null, 1);

INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('03.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('04.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('05.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('06.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('07.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('10.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('11.04.2017', 'DD.MM.YYYY.'), 3, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('12.04.2017', 'DD.MM.YYYY.'), 3, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('13.04.2017', 'DD.MM.YYYY.'), 3, false, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('18.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('19.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('20.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('21.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('24.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('25.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('26.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('27.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
INSERT INTO attendance (aid, adate, cid, awpr, jid, version) VALUES (NEXTVAL('attendance_aid_seq'), TO_DATE('28.04.2017', 'DD.MM.YYYY.'), 3, true, null, 1);
