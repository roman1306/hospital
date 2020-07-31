SELECT string_agg(s.name, ',') as specialities, d.doctor_id, u.name || ' ' || u.surname as name, description, photo
FROM doctors d
         join users u on d.user_id = u.username
         join doctor_specialities ds on d.doctor_id = ds.doctor_id
         join specialties s on ds.speciality_id = s.speciality_id
group by d.doctor_id, u.name || ' ' || u.surname, description, photo