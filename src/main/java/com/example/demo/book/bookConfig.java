package com.example.demo.book;
import javax.persistence.*;


import com.example.demo.cart.cart;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class bookConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            bookRepository repository){


        return args -> {
            book hobbit = new book(
                    11L,
                    "Hobbit",
                    "J. R. R. Tolkien",
                    "George Allen & Unwin",
                    1937,
                    29.99,
                    45 ,
                    book.category.Fantasy,"https://images-na.ssl-images-amazon.com/images/I/61zxVpKmL8L.jpg"
            );
            book it = new book(
                    22L,
                    "IT",
                    "Stephen King",
                    "Viking",
                    1986,
                    39.99,
                    25 ,
                    book.category.Horror, "https://i.ebayimg.com/images/g/glQAAOSwiTNgAEMG/s-l500.jpg"
            );
            book ToE = new book(
                    33L,
                    "The Theory of Everything: The Origin and Fate of the Universe",
                    "Stephen Hawking",
                    "Jaico Publishing House",
                    2002,
                    79.99,
                    125 ,
                    book.category.Scifi,"https://prestigebookshop.com/wp-content/uploads/2019/02/book-image-5642.jpg"
            );
            book DVC = new book(
                    44L,
                    "The Da Vinci Code",
                    "Dan Brown",
                    "Doubleday",
                    2003,
                    69.99,
                    72 ,
                    book.category.Dramat,"https://anylang.net/sites/default/files/styles/book_image/public/covers/the-da-vinci-code-589f9cee3df78c4758a2d9e7.jpg?itok=Qs2nkb__"
            );
            book FiOS = new book(
                    55L,
                    "The Fault in Our Stars",
                    "John Green",
                    "Dutton Books",
                    2012,
                    39.99,
                    12 ,
                    book.category.Romance,"https://images-na.ssl-images-amazon.com/images/I/51BYcXvTimL._SX332_BO1,204,203,200_.jpg"
            );
            book OLS = new book(
                    66L,
                    "One Last Stop",
                    " Casey McQuiston",
                    "Dutton Books",
                    2012,
                    25.99,
                    12 ,
                    book.category.Romance,"https://cf-taniaksiazka.statiki.pl/images/large/997/9788382342307.jpg"
            );
            book Mns = new book(
                    77L,
                    "Milość na swieta",
                    "Christina Lauren",
                    "Dutton Books",
                    2012,
                    23.90,
                    12 ,
                    book.category.Romance,"https://cf-taniaksiazka.statiki.pl/images/large/CF0/9788366555853.jpg"
            );
            book S = new book(
                    88L,
                    "Sparks",
                    "Nicholas Sparks",
                    "Dutton Books",
                    2012,
                    32.90,
                    12 ,
                    book.category.Romance,"https://cf-taniaksiazka.statiki.pl/images/large/F26/9788382157185.jpg"
            );
            book E = new book(
                    99L,
                    "Eter",
                    "Aniela Wilk",
                    "Dutton Books",
                    2012,
                    26.90,
                    12 ,
                    book.category.Romance,"https://cf-taniaksiazka.statiki.pl/images/large/DF2/9788328719422.jpg"
            );
            book PR = new book(
                    100L,
                    "Parker Rain",
                    "Anna Wolf",
                    "Dutton Books",
                    2012,
                    26.90,
                    12 ,
                    book.category.Romance,"https://cf-taniaksiazka.statiki.pl/images/large/B26/9788328719316.jpg"
            );
            book M = new book(
                    101L,
                    "Matnia",
                    "Paulina Jurga",
                    "Dutton Books",
                    2012,
                    29.99,
                    12 ,
                    book.category.Romance,"https://cf-taniaksiazka.statiki.pl/images/large/BF6/9788381350891.jpg"
            );
            book RD = new book(
                    101L,
                    "Russian Devil",
                    "Cordelia Frost",
                    "Dutton Books",
                    2012,
                    39.99,
                    12 ,
                    book.category.Romance,"https://cf-taniaksiazka.statiki.pl/images/large/C53/9788328381056.jpg"
            );
            book OW = new book(
                    111L,
                    "Wiedzmin. Tom 1. Ostatnie zyczenie",
                    "Andrzej Sapkowski",
                    "George Allen & Unwin",
                    1937,
                    52.99,
                    45 ,
                    book.category.Fantasy,"https://cf-taniaksiazka.statiki.pl/images/large/123/68007901377KS.jpg"
            );
            book CP = new book(
                    112L,
                    "Wiedzmin. Tom 4. Czas pogardy",
                    "Andrzej Sapkowski",
                    "George Allen & Unwin",
                    1937,
                    32.99,
                    45 ,
                    book.category.Fantasy,"https://cf-taniaksiazka.statiki.pl/images/large/A9E/9788375780666.jpg"
            );
            book MP= new book(
                    113L,
                    "Miecz przeznaczenia. Wiedzmin. Tom 2",
                    "Andrzej Sapkowski",
                    "George Allen & Unwin",
                    1937,
                    29.99,
                    45 ,
                    book.category.Fantasy,"https://cf-taniaksiazka.statiki.pl/images/large/A0A/9788375780642.jpg"
            );
            book KE= new book(
                    114L,
                    "Wiedzmin. Tom 3. Krew elfow",
                    "Andrzej Sapkowski",
                    "George Allen & Unwin",
                    1937,
                    34.99,
                    45 ,
                    book.category.Fantasy,"https://cf-taniaksiazka.statiki.pl/images/large/0F7/9788375780659.jpg"
            );
            book D= new book(
                    115L,
                    "Diuna. Kroniki Diuny. Tom 1",
                    "Frank Herbert",
                    "George Allen & Unwin",
                    1937,
                    28.99,
                    45 ,
                    book.category.Fantasy,"https://cf-taniaksiazka.statiki.pl/images/large/32D/9788381880572.jpg"
            );
            book O= new book(
                    116L,
                    "Outsider",
                    "Stephen King",
                    "George Allen & Unwin",
                    1937,
                    22.99,
                    45 ,
                    book.category.Fantasy,"https://cf-taniaksiazka.statiki.pl/images/large/EA1/9788381690805.jpg"
            );
            book B= new book(
                    117L,
                    "Battle Royale",
                    "Koushun Takami",
                    "George Allen & Unwin",
                    1937,
                    30.99,
                    45 ,
                    book.category.Fantasy,"https://cf-taniaksiazka.statiki.pl/images/large/B0E/9788377313626.jpg"
            );
            book OC= new book(
                    118L,
                    "Octula",
                    "Maya Motayne",
                    "George Allen & Unwin",
                    1937,
                    27.99,
                    45 ,
                    book.category.Fantasy,"https://cf-taniaksiazka.statiki.pl/images/large/A0F/9788382660210.jpg"
            );
            book MY = new book(
                    221L,
                    "Misery",
                    "Stephen King",
                    "Viking",
                    1986,
                    25.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/87D/9788382343618.jpg"
            );
            book BA = new book(
                    222L,
                    "Bastion",
                    "Stephen King",
                    "Viking",
                    1986,
                    35.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/F16/9788381253888.jpg"
            );
            book P = new book(
                    223L,
                    "Petla",
                    "Kamil Staniszek",
                    "Viking",
                    1986,
                    24.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/429/9788377313992.jpg"
            );
            book DO = new book(
                    224L,
                    "Doberman",
                    "Jacek Piekielko",
                    "Viking",
                    1986,
                    38.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/3AE/9788366939356.jpg"
            );
            book K = new book(
                    225L,
                    "Krucyfiks",
                    "Chris Carter",
                    "Viking",
                    1986,
                    23.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/D76/9788381100076.jpg"
            );
            book A = new book(
                    226L,
                    "Autopsja",
                    "Tess Gerritsen",
                    "Viking",
                    1986,
                    29.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/19F/9788381255790.jpg"
            );
            book Da = new book(
                    227L,
                    "Dracula",
                    "Tess Bram Stoker",
                    "Viking",
                    1986,
                    37.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/FD6/9788377312872.jpg"
            );
            book NOS4A2 = new book(
                    228L,
                    "NOS4A2",
                    "Joe Hill",
                    "Viking",
                    1986,
                    34.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/DA0/9788381253673.jpg"
            );
            book G = new book(
                    229L,
                    "Gambit",
                    "Maciej Siembieda",
                    "Viking",
                    1986,
                    28.99,
                    25 ,
                    book.category.Horror, "https://cf-taniaksiazka.statiki.pl/images/large/B11/9788326827884.jpg"
            );
            book WW = new book(
                    331L,
                    "Wonder Woman",
                    "Leigh Bardugo",
                    "Jaico Publishing House",
                    2002,
                    49.99,
                    125 ,
                    book.category.Scifi,"https://cf-taniaksiazka.statiki.pl/images/large/67D/9788366409408.jpg"
            );
            book WS = new book(
                    332L,
                    "Wyspa Sachalin",
                    "Eduard Wierkin",
                    "Jaico Publishing House",
                    2002, 39.99,
                    125 ,
                    book.category.Scifi,"https://cf-taniaksiazka.statiki.pl/images/large/7B5/9788381433570.jpg"
            );
            book o = new book(
                    333L,
                    "Obcy 3",
                    "Alan Dean Foster",
                    "Jaico Publishing House",
                    2002,
                    30.99,
                    125 ,
                    book.category.Scifi,"https://cf-taniaksiazka.statiki.pl/images/large/819/9788377313640.jpg"
            );
            book c = new book(
                    334L,
                    "Cyberiada",
                    "Stanisław Lem",
                    "Jaico Publishing House",
                    2002,
                    28.99,
                    125 ,
                    book.category.Scifi,"https://cf-taniaksiazka.statiki.pl/images/large/F03/9788308055281.jpg"
            );
            book l = new book(
                    335L,
                    "Limes inferior",
                    "Janusz Andrzej Zajdel",
                    "Jaico Publishing House",
                    2002,
                    25.49,
                    125 ,
                    book.category.Scifi,"https://cf-taniaksiazka.statiki.pl/images/large/E0F/51311801377KS.jpg"
            );
            book s = new book(
                    336L,
                    "Solaris",
                    "Stanisław Lem",
                    "Jaico Publishing House",
                    2002,
                    27.99,
                    125 ,
                    book.category.Scifi,"https://cf-taniaksiazka.statiki.pl/images/large/8DD/9788308070512.jpg"
            );
            book p = new book(
                    336L,
                    "Paradyzja",
                    "Janusz Andrzej Zajdel",
                    "Jaico Publishing House",
                    2002,
                    37.19,
                    125 ,
                    book.category.Scifi,"https://cf-taniaksiazka.statiki.pl/images/large/C7D/9788375781892.jpg"
            );
            book b = new book(
                    441L,
                    "Balladyna",
                    "Juliusz Słowacki",
                    "Doubleday",
                    2003,
                    13.99,
                    72 ,
                    book.category.Dramat,"https://cf-taniaksiazka.statiki.pl/images/large/796/9788375178500.jpg"
            );
            book z = new book(
                    442L,
                    "Zemsta",
                    " Aleksander Fredro",
                    "Doubleday",
                    2003,
                    18.99,
                    72 ,
                    book.category.Dramat,"https://cf-taniaksiazka.statiki.pl/images/large/E36/9788380738188.jpg"
            );
            book m = new book(
                    443L,
                    "Mroczne wody",
                    " Aleksander Fredro",
                    "Doubleday",
                    2003,
                    27.99,
                    72 ,
                    book.category.Dramat,"https://cf-taniaksiazka.statiki.pl/images/large/0AE/9788324584826.jpg"
            );
            book f = new book(
                    444L,
                    "Folwark zwierzęcy",
                    "George Orwell",
                    "Doubleday",
                    2003,
                    11.39,
                    72 ,
                    book.category.Dramat,"https://cf-taniaksiazka.statiki.pl/images/large/B2C/9788366576711.jpg"
            );
            book n = new book(
                    445L,
                    "Niewierna",
                    "Monforte Reyes",
                    "Doubleday",
                    2003,
                    36.99,
                    72 ,
                    book.category.Dramat,"https://cf-taniaksiazka.statiki.pl/images/large/5BA/9788327714077.jpg"
            );
            book ss = new book(
                    446L,
                    "Sen nocy letniej",
                    "William Shakespeare",
                    "Doubleday",
                    2003,
                    24.99,
                    72 ,
                    book.category.Dramat,"https://cf-taniaksiazka.statiki.pl/images/large/948/9788366371538.jpg"
            );
            book oo= new book(
                    447L,
                    "Klasyka. Otello",
                    "William Shakespeare",
                    "Doubleday",
                    2003,
                    27.99,
                    72 ,
                    book.category.Dramat,"https://cf-taniaksiazka.statiki.pl/images/large/C72/9788366022874.jpg"
            );
            book mm= new book(
                    1L,
                    "Mów mi Win",
                    "Harlan Coben",
                    "Doubleday",
                    2003,
                    25.99,
                    72 ,
                    book.category.Thiller,"https://cf-taniaksiazka.statiki.pl/images/large/EFC/9788382157079.jpg"
            );
            book t= new book(
                    2L,
                    "Terapeutka",
                    "B. A. Paris",
                    "Doubleday",
                    2003,
                    26.99,
                    72 ,
                    book.category.Thiller,"https://cf-taniaksiazka.statiki.pl/images/large/F87/9788382154115.jpg"
            );
            book Mursz= new book(
                    3L,
                    "Mursz",
                    "Ewa Przydryga",
                    "Doubleday",
                    2003,
                    21.99,
                    72 ,
                    book.category.Thiller,"https://cf-taniaksiazka.statiki.pl/images/large/826/9788328716735.jpg"
            );
            book Oni= new book(
                    4L,
                    "Oni",
                    "Joanna Opiat-Bojarska",
                    "Doubleday",
                    2003,
                    26.99,
                    72 ,
                    book.category.Thiller,"https://cf-taniaksiazka.statiki.pl/images/large/D7D/9788382510386.jpg"
            );
            book V2= new book(
                    5L,
                    "V2",
                    "Robert Harris",
                    "Doubleday",
                    2003,
                    28.99,
                    72 ,
                    book.category.Thiller,"https://cf-taniaksiazka.statiki.pl/images/large/03C/9788382155754.jpg"
            );
            book Chwasty= new book(
                    6L,
                    "Chwasty",
                    "Krzysztof Jozwik",
                    "Doubleday",
                    2003,
                    42.99,
                    72 ,
                    book.category.Thiller,"https://cf-taniaksiazka.statiki.pl/images/large/704/9788381956543.jpg"
            );
            book Arka= new book(
                    7L,
                    "Arka",
                    "Krzysztof Jozwik",
                    "Doubleday",
                    2003,
                    37.99,
                    72 ,
                    book.category.Thiller,"https://cf-taniaksiazka.statiki.pl/images/large/941/9788380919938.jpg"
            );



            List<book> is = List.of(hobbit,Mursz,Arka,Chwasty,V2,mm,Oni,o,t,oo,p,f,n,ss,s,z,m,l,b,c,WW,WS,G,NOS4A2,Da,DO,it,A,K,P,ToE,DVC,FiOS,OLS,Mns,S,BA,RD,M,PR,E,O,B,OC,D,KE,MP,CP,OW,MY);
            for(book x: is ){
               boolean bla = repository.findBookBytitle(x.getTitle()).isPresent();
                System.out.println(bla);
                if(!bla){
                    repository.save(x);

                }
            }
            book bac = new book(
                    51L,
                    "Opowiesci z Narni",
                    "Zielony Johnny",
                    "Zielen i trawa",
                    2021,
                    100.00,
                    2 ,
                    book.category.Romance,"https://images-na.ssl-images-amazon.com/images/I/51BYcXvTimL._SX332_BO1,204,203,200_.jpg"
            );

            cart crt = new cart();


        };


    }
}
