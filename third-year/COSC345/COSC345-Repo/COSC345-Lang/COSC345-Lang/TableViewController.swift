//
//  Leaderboards.swift
//  COSC345-Lang
//
//  Created by Liam Flynn on 12/08/22.
//

import UIKit

/**
    Struct that has the variables that will be displayed in each cell
 */
struct Player{
    var name: String
    var score: Int
}

/**
    View Controller for the table
 */
class PlayerTableViewController: UITableViewController {
    /**
        Data that is displayed in the table
     */
    let players = [
        Player(name: MainMenu.getName(), score: HomeScreen.getScore()),
        Player(name: "Bruce", score: 5),
        Player(name: "Bob", score: 4),
        Player(name: "Brent", score: 3),
        Player(name: "Keith", score: 2),
        Player(name: "Rob", score: 1),
    ]

    /**
        Makes as many cells as the length of objects in players
     
     - parameters:
        - tableView: The table
        - numberOfRowsInSection: Rows in the table
     - returns:
        - Int: number of rows in the table
     */
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        self.players.count
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
        let cell = tableView.dequeueReusableCell(withIdentifier: "PlayerCell", for: indexPath)

        let player = players[indexPath.row]
        cell.textLabel?.text = player.name + "   " + String(player.score)

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
        "Leaderboard"
    }
}
