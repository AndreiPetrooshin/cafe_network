DELETE FROM director;
DELETE FROM cafe;
DELETE FROM drink;

INSERT INTO director (first_name, last_name, email, phone_number) VALUES
  ('Andrei', 'Petrooshin', 'andrei@mail.ru', '+375295559297'),
  ('Valerii', 'Cezarev', 'cezarev@mail.ru', '+375297815648'),
  ('Evgenii', 'Kovalev', 'kovalev@mail.ru', '+375297844687');

INSERT INTO cafe (address, name, dir_id, rating)  VALUES
  ('Zhodino, ul.Lenina 12, d.12', 'Coffee_Saund', 2, 5.0),
  ('Minsk, pr. Nezavisimosti 11', 'Coffee_Like', 1, 4.6),
  ('Borisov, ul. Molodezhnaia 11', 'GoodCoffee', 3, 4.7),
  ('Minsk, pr. Nezavisimosti 4', 'GetCoffee', 1, 5.0);

INSERT INTO drink (name, price, capacity, cafe_id) VALUES
  ('kapuchino', 2.50, 250, 2),
  ('americano', 2.50, 250, 2),
  ('latte', 3.50, 350, 2),
  ('espresso', 2.50, 250, 2),
  ('kapuchino', 1.99, 250, 1),
  ('americano', 1.99, 250, 1),
  ('latte', 2.99, 350, 1),
  ('espresso', 1.99, 250, 1),
  ('kapuchino', 2.10, 250, 3),
  ('americano', 2.10, 250, 3),
  ('latte', 3, 350, 3),
  ('espresso', 2.10, 250, 3),
  ('makachino', 2.10, 300, 3);




