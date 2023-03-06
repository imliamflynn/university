//
//  CheatSheetTableViewController.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 30/09/22.
//

import UIKit

/**
 Struct that has the variables that the cell will display
 */
struct Word{
    var english: String
    var maori: String
    var french: String
    var spanish: String
}

/**
  Table view controller
 */
class CheatSheetTableViewController: UITableViewController {
    
        /**
            List of objects that the table will display
         */
        let words = [
            Word(english: "Hello", maori: "Kia Ora", french: "Bonjour", spanish: "Hola"),
            Word(english: "Please", maori: "Tena koa", french: "S'il vous plaît", spanish: "Hola"),
            Word(english: "Thank you", maori: "Mauruuru koe", french: "Merci", spanish: "Gracias"),
            Word(english: "You're Welcome", maori: "Tena koe", french: "De rien", spanish: "De nada"),
            Word(english: "Sorry", maori: "Aroha mai", french: "Pardon", spanish: "Lo siento"),
            Word(english: "Yes", maori: "Ae", french: "Oui", spanish: "Si"),
            Word(english: "No", maori: "Kao", french: "Non", spanish: "No"),
            Word(english: "Name", maori: "Ko ‘name’ ahau", french: "Je suis ‘name’", spanish: "Yo soy ‘name’"),
            Word(english: "How are you?", maori: "Kei te pehea koe?", french: "Comment vas-tu?", spanish: "¿Cómo estás?"),
            Word(english: "Goodbye", maori: "haere rā", french: "au revoir", spanish: "adiós"),
            Word(english: "Place", maori: "Wahi", french: "le lieu", spanish: "Lugar"),
            Word(english: "Restaurant", maori: "wharekai", french: "le restaurant", spanish: "restaurante"),
            Word(english: "Hotel", maori: "Hotera", french: "Hôtel", spanish: "Hotel"),
            Word(english: "Airport", maori: "Taunga rererangi", french: "Aéroport", spanish: "Aeropuerto"),
            Word(english: "Market", maori: "Te maakete", french: "Marché", spanish: "Mercado"),
            Word(english: "Help", maori: "Awhina", french: "Aider", spanish: "Ayuda"),
            Word(english: "where", maori: "kei hea", french: "Où", spanish: "dónde"),
            Word(english: "are", maori: "he", french: "sommes", spanish: "son"),
            Word(english: "you", maori: "koe", french: "tu", spanish: "tú"),
            Word(english: "from", maori: "mai", french: "de", spanish: "de"),
            Word(english: "what", maori: "aha", french: "quelle", spanish: "qué"),
            Word(english: "do", maori: "mahi", french: "fais", spanish: "hacer"),
            Word(english: "is", maori: "ko", french: "est", spanish: "es"),
            Word(english: "your", maori: "tou", french: "ton", spanish: "su"),
            Word(english: "phone", maori: "waea", french: "telephoner", spanish: "teléfono"),
            Word(english: "number", maori: "tau", french: "Numéro", spanish: "Numéro"),
            Word(english: "nice", maori: "pai", french: "agréable", spanish: "bonita"),
            Word(english: "to", maori: "ki", french: "à", spanish: "a"),
            Word(english: "meet", maori: "tutaki", french: "recontrer", spanish: "renuir"),
            Word(english: "that", maori: "tera", french: "cette", spanish: "esa"),
            Word(english: "helps", maori: "awhina", french: "aide", spanish: "ayuda"),
            Word(english: "alot", maori: "nui", french: "beaucoup", spanish: "mucha"),
            Word(english: "does", maori: "mahi", french: "est-ce quq", spanish: "lo hace"),
            Word(english: "this", maori: "tenei", french: "cetta", spanish: "esta"),
            Word(english: "sound", maori: "tangi", french: "du son", spanish: "sonido"),
            Word(english: "I", maori: "I", french: "je", spanish: "yo"),
            Word(english: "not", maori: "ne pas", french: "no", spanish: "kaore"),
            Word(english: "understand", maori: "mohio", french: "comprendre", spanish: "comprender"),
            Word(english: "could", maori: "taea", french: "pourrait", spanish: "pudo"),
            Word(english: "repeat", maori: "tukura", french: "répéter", spanish: "repetir"),
            Word(english: "spell", maori: "karakia", french: "sort", spanish: "deletrear"),
            Word(english: "mean", maori: "tikanga", french: "moyenne", spanish: "media"),
            Word(english: "me", maori: "ahau", french: "moi", spanish: "yo"),
            Word(english: "can", maori: "taea", french: "boîte", spanish: "pueden"),
            Word(english: "know", maori: "modio", french: "connaître", spanish: "saber"),
            Word(english: "my", maori: "taku", french: "ma", spanish: "mi"),
            Word(english: "size", maori: "rahi", french: "taille", spanish: "talla"),
            Word(english: "much", maori: "nui", french: "beaucoup", spanish: "mucha"),
            Word(english: "cost", maori: "utu", french: "Coût", spanish: "costo"),
            Word(english: "need", maori: "hiahia", french: "besoin", spanish: "necesitar"),
            Word(english: "bag", maori: "putea", french: "sac", spanish: "bolsa"),
            Word(english: "someone", maori: "tetahi", french: "quelqu'une", spanish: "alguien"),
            Word(english: "carry", maori: "kawe", french: "porter", spanish: "llevar"),
            Word(english: "time", maori: "wā", french: "temps", spanish: "tiempo"),
            Word(english: "our", maori: "to tatou", french: "notre", spanish: "nuestra"),
            Word(english: "meeting", maori: "hui", french: "recountre", spanish: "reunión")
        ]

        /**
            Gets the amount of rows in the table
         - parameters:
            - tableView: gets the table
            - numberOfRowsInSection: number of rows in the table
         - returns:
            - Int: the number of rows
         */
        override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
            self.words.count
        }

        /**
        Creates the view for each cell in the table by adding the text onto the label
      
         - Parameters:
            - tableView: Gets the table
            - cellForRowAt: the index of the cell
         - Returns:
            - UITableViewCell: Cell
         */
        override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
            let cell = tableView.dequeueReusableCell(withIdentifier: "WordCell", for: indexPath)

            let word = words[indexPath.row]
            cell.textLabel?.text = word.english + "   " + word.maori + "   " + word.french + "   " + word.spanish

            return cell
        }
        
        /**
         The name at the top of the table
         - parameters:
            - tableView: the table
            - titleForHeaderInSection: header for the table
         - returns:
            - String: name for table
         */
        override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
            "CheatSheet"
        }
}
