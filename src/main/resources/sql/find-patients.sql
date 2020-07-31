select name, surname, birth_date
from patients
         join users on patients.user_id = users.username