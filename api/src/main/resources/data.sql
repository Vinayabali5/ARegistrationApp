insert into acceptanceandregistration.ethnicity (ethnicity_id, code, description) values (1, 'WB', 'White - British'), (2, 'AF', 'African'), (3, 'IN', 'Indian');

insert into acceptanceandregistration.lldd_health_problem (lldd_health_problem_id, code, description) values (1, 'Yes', 'Yes - the student considers themselves to have a LLDD health problem.'), (2, 'No', 'No - the student does not consider themselve to have an LLDD health problem'), (99, 'Prefer Not To Say', 'The student would prefer not to say if they have an LLDD health problem.');

insert into acceptanceandregistration.lldd_health_problem_category (lldd_health_problem_category_id, code, description) values (1, '1', 'Visual Impairment'), (2, '2', 'Autism'), (3, '10', 'Speech, Language and Communication Needs');

insert into acceptanceandregistration.student (student_id, link_id, legal_first_name, legal_surname, dob, school_name, interview_date) values (123456, '12345', 'Joe', 'Blogs', '2015-11-18', 'Some School', '2021-11-18 17:30:00'), (123457, '12346', 'Jane', 'Blogs', '2015-11-18', 'Another School', '2021-11-18 18:00:00');

