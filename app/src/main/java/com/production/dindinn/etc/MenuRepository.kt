package com.production.dindinn.etc

import com.production.dindinn.models.MenuModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MenuRepository {

    private val menu = mutableListOf<MenuModel>()

  /*fun getAllMenuItems()= Observable.fromCallable<List<MenuModel>>{
      Thread.sleep(9000)
      menu.addAll(listOf(
              MenuModel(
                      20000001,
                      "Margherita",
                      "https://i.ibb.co/tDQSfjG/p-1.jpg",
                      "Good food is a combination of mouth-watering flavours and healthy ingredients. Your favourite pizza gets a healthy makeover with a multi-grain base",
                      "pizza",
                      "spicy",
                      "400 grams, 30 cm",
                      45
              ),
              MenuModel(
                      20000002,
                      "Marinara",
                      "https://i.ibb.co/H7kq93Q/p-2.jpg",
                      "This Italian favorite pizza is a delicious mix of flat bread or base topped with cheese, chillies, onion, garlic sauce and chunks of chicken.",
                      "pizza",
                      "vegan",
                      "250 grams, 35 cm",
                      50
              ),
              MenuModel(
                      20000003,
                      "Carbonara",
                      "https://i.ibb.co/kGfD2rt/p-3.jpg",
                      "Make way for the all time favourite pizza!  Oargherita Pizza is to many the true Italian flag as it was created resembling the colors of the Italian flag.",
                      "pizza",
                      "spicy",
                      "500 grams, 45 cm",
                      35
              ),
              MenuModel(
                      20000004,
                      "Frutti di Mare",
                      "https://i.ibb.co/RScxSJP/p-4.jpg",
                      "Think out-of-the-box-cooking, think fusion food. This is what you get when Italian cooking marries Indian flavours.",
                      "pizza",
                      "spicy",
                      "250 grams, 25 cm",
                      60
              ),
              MenuModel(
                      20000005,
                      "Quattro Formaggi",
                      "https://i.ibb.co/VTzzVFh/p-5.jpg",
                      "A brilliant, gorgeous looking pizza that is high on flavour yet low on calories can strike a deal with anyone, right.",
                      "pizza",
                      "vegan",
                      "350 grams, 55 cm",
                      65
              ),
              MenuModel(
                      20000006,
                      "Gunkan Maki",
                      "https://i.ibb.co/KFXJDbj/s-1.jpg",
                      "Technically not sushi! While sushi is fish that is served with rice and may be adorned with other ingredients, sashimi is simply the raw fish, served as is.",
                      "sushi",
                      "vegan",
                      "800 grams, 40 pieces",
                      120
              ),
              MenuModel(
                      20000007,
                      "Temaki",
                      "https://i.ibb.co/RbZLNHj/s-2.jpg",
                      "Chirashi, meaning, “scattered,” is a bowl of vinegared rice topped with a mix of raw fish (typically chef’s choice) and various garnishes.",
                      "sushi",
                      "spicy",
                      "600 grams, 30 pieces",
                      80
              ),
              MenuModel(
                      20000008,
                      "Narezushi",
                      "https://i.ibb.co/hYDgdbm/s-3.jpg",
                      "Maki is cut rolled sushi, traditionally made with a sheet of nori, wrapped around a layer of rice, vegetables, and fish, then rolled up using a special bamboo mat, and cut into 6-8 pieces.",
                      "sushi",
                      "vegan",
                      "421 grams, 25 pieces",
                      75
              ),
              MenuModel(
                      20000009,
                      "Nigiri",
                      "https://i.ibb.co/894nyWF/s-4.jpg",
                      "Nigiri is a style of sushi that is made by molding a ball of vinegared rice by hand and topping it with a slice of raw fish. It’s usually served with two pieces and can be eaten with the hands.",
                      "sushi",
                      "vegan",
                      "100 grams, 15pieces",
                      90
              ),
              MenuModel(
                      20000010,
                      "Sasazushi",
                      "https://i.ibb.co/q01CC1C/s-5.jpg",
                      "The sushi we know today is a far cry from where it began. The original sushi was once a staple dish around various regions of Asia and was salted fish preserved in fermented rice.",
                      "sushi",
                      "vegan",
                      "900 grams, 60 pieces",
                      85
              ),
              MenuModel(
                      20000011,
                      "Chocolate Smoothie",
                      "https://i.ibb.co/CnTf3kM/d-1.jpg",
                      "A smoothie is a drink made from pureed raw fruit and/or vegetables, typically using a blender. A smoothie often has a liquid base such as water, fruit juice.",
                      "drinks",
                      "none",
                      "300 ml, 2 servings",
                      20
              ),
              MenuModel(
                      20000012,
                      "Mulled apple juice",
                      "https://i.ibb.co/hcYs8dH/d-2.jpg",
                      "According to the label, the ingredients of Apple Juicy Juice are apple juice concentrate, water, ascorbic acid -- commonly known as vitamin C -- and malic acid.",
                      "drinks",
                      "none",
                      "200 ml, 1 servings",
                      35
              ),
              MenuModel(
                      20000013,
                      "Homemade cordial",
                      "https://i.ibb.co/BzVTt5X/d-3.jpg",
                      "The mixture is then gently mashed with a muddler. The mint leaves should only be bruised to release the essential oils and should not be shredded.",
                      "drinks",
                      "none",
                      "900 ml, 4 servings",
                      15
              ),
              MenuModel(
                      20000014,
                      "Lemonade",
                      "https://i.ibb.co/1qLpxLM/d-4.jpg",
                      "Lemonade is a colourless sweet fizzy drink. A drink that is made from lemons, sugar, and water and is not fizzy can also be referred to as lemonade.",
                      "drinks",
                      "none",
                      "600 ml, 2 servings",
                      25
              ),
              MenuModel(
                      20000015,
                      "Coca Cola",
                      "https://i.ibb.co/fCwtwrh/d-5.jpg",
                      "The Coca-Cola Company is a beverage retailer, manufacturer and marketer of non-alcoholic beverage concentrates and syrups.",
                      "drinks",
                      "none",
                      "100 ml, 3 servings",
                      30
              )
      ))
      menu
  }.subscribeOn(Schedulers.io())*/

}