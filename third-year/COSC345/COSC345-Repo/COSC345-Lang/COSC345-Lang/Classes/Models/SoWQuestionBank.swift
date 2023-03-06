//
//  SowQuestionBank.swift
//  COSC345-Lang
//
//  Created by Mahfuz Abdul Razak on 22/09/22.
//

/*
 Class to create arrays to hold questions for Sea of Words
*/
import Foundation

class SoWQuestionBank {
    var list = [SoWQuestions]()
    var french = [SoWQuestions]()
    var maori = [SoWQuestions]()
    
    init(){
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Good",choiceA: "Si",choiceB: "Bueno",choiceC: "Gracias",choiceD: "El no Sabe",answer: 2))
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Bad",choiceA: "Malo",choiceB: "tonto",choiceC: "Correr", choiceD: "Detengasse",answer: 1))
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Hello",choiceA: "Ciao",choiceB: "Salto",choiceC: "Patada", choiceD: "Hola",answer: 4))
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Goodbye",choiceA: "Chalupa",choiceB: "Carnitas",choiceC: "Adios", choiceD: "Fajita",answer: 3))
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Today",choiceA: "Este Dia",choiceB: "Manana",choiceC: "El Dia de Ayer", choiceD: "La Proxima Semana", answer: 1))
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Tomorrow",choiceA: "Si",choiceB: "Infierno",choiceC: "Mierda", choiceD: "Manana",answer: 4))
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Okay",choiceA: "Okey",choiceB: "Estupido",choiceC: "Hijo", choiceD: "Padre",answer: 1))
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Mother",choiceA: "Padre",choiceB: "Papi",choiceC: "Hijo",choiceD: "Sabe",answer: 2))
        list.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Friend",choiceA: "Si",choiceB: "Puta",choiceC: "Amigo",choiceD: "El no Sabe",answer: 3))
        
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Hello",choiceA: "Jour",choiceB: "Bonjour",choiceC: "Oui",choiceD: "Fille",answer: 1))
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Goodbye",choiceA: "Chat",choiceB: "Temps",choiceC: "Monde", choiceD: "Au Revoir",answer: 4))
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Yes",choiceA: "Raison",choiceB: "Homme",choiceC: "Bonne Nuit", choiceD: "Oui",answer: 4))
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "No",choiceA: "Amour",choiceB: "Belle",choiceC: "Non", choiceD: "Oui",answer: 3))
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Excuse Me",choiceA: "Excuse-moi",choiceB: "De Rien",choiceC: "Beau", choiceD: "Bonne", answer: 1))
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Thank You",choiceA: "Temps",choiceB: "Beu",choiceC: "Belle", choiceD: "Merci",answer: 4))
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "You're Welcome",choiceA: "De Rien",choiceB: "Fracais",choiceC: "Fort", choiceD: "Bounjour",answer: 1))
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Please",choiceA: "Monsiuer",choiceB: "S'il Vous Plait",choiceC: "Monde",choiceD: "Jour",answer: 2))
        french.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Good Night",choiceA: "Chien",choiceB: "Madame",choiceC: "Bonne Nuit",choiceD: "Bonsoir",answer: 3))
        
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Hello",choiceA: "Kia Ora",choiceB: "Aroha",choiceC: "Hui",choiceD: "Hapu",answer: 1))
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Goodbye",choiceA: "Iti",choiceB: "Kai",choiceC: "Kia Ora",choiceD: "Kaumatau",answer: 3))
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Yes",choiceA: "Karaki",choiceB: "Ae",choiceC: "Marae",choiceD: "Mahi",answer: 2))
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "No",choiceA: "Kao",choiceB: "Mana",choiceC: "Maunga",choiceD: "Moana",answer: 1))
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Excuse Me",choiceA: "Puku",choiceB: "Tama",choiceC: "Motu",choiceD: "Aroha Mai",answer: 4))
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Thank You",choiceA: "Tamariki",choiceB: "Tena Koe",choiceC: "Tuatara",choiceD: "Wai",answer: 2))
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "You're Welcome",choiceA: "Whanau",choiceB: "Waiata",choiceC: "Ka Nui Te Mihi",choiceD: "Waka",answer: 3))
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Please",choiceA: "Tipuna",choiceB: "Tapu",choiceC: "Tane",choiceD: "Tena Koe",answer: 4))
        maori.append(SoWQuestions(quest: "Select the word with the same meaning",questWord: "Good Night",choiceA: "Po Pai",choiceB: "Pa",choiceC: "Paunamu",choiceD: "Tangi",answer: 1))
        
    }
    

}
