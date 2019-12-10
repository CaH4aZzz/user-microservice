DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       INT auto_increment primary key,
    name     VARCHAR(25)  NOT NULL,
    username VARCHAR(25)  NOT NULL,
    age      INT(3)       NOT NULL,
    gender   VARCHAR(10)  NOT NULL,
    address  VARCHAR(255) NOT NULL,
    info  VARCHAR(1000)
);

INSERT INTO users (name, username, age, gender, address, info)
VALUES ('Oleg', 'Dendy', 33, 'male', 'Dnipro', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Odio morbi quis commodo odio aenean. Turpis egestas sed tempus urna et. Magnis dis parturient montes nascetur ridiculus mus mauris. Ultricies mi quis hendrerit dolor magna. Morbi non arcu risus quis varius quam. Integer eget aliquet nibh praesent. Commodo quis imperdiet massa tincidunt. Praesent semper feugiat nibh sed pulvinar proin gravida. Tristique sollicitudin nibh sit amet commodo nulla facilisi. Consequat ac felis donec et odio pellentesque diam volutpat.'),
       ('Max', 'CaH4aZzz', 20, 'male', 'Kyiv', ' Luctus venenatis lectus magna fringilla urna porttitor rhoncus dolor purus. Tempor orci eu lobortis elementum nibh tellus molestie nunc. Duis tristique sollicitudin nibh sit amet commodo nulla facilisi nullam. Ut etiam sit amet nisl purus in mollis nunc sed. Adipiscing bibendum est ultricies integer quis auctor elit sed vulputate. Nunc sed id semper risus.'),
       ('Petro', 'AngryAngel', 47, 'male', 'Chicago', NULL),
       ('Olena', 'SailorMoon', 23, 'female', 'Odessa', 'Aliquam malesuada bibendum arcu vitae. Morbi quis commodo odio aenean sed. Lorem ipsum dolor sit amet consectetur. Elementum facilisis leo vel fringilla est. Sociis natoque penatibus et magnis dis parturient. Consequat ac felis donec et. Non arcu risus quis varius. Nunc sed augue lacus viverra vitae congue eu consequat.');
