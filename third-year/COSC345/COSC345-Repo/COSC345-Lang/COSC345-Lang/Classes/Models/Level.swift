//
//  Level.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 16/08/22.
//

import Foundation

/**
    Struct that finds the data that will be displayed in the Drag and Drop game
 */
public struct Level {
  //let pointsPerTile: Int
  //let timeToSolve: Int
  let sentence: [NSArray]
    /**
        Initialser method searches through the .plist file to get the required information for the game
        - Parameters:
            - LevelNumber: This gets the strings from the .plist files that are then displayed into the game
    */
  init(levelNumber: Int) {
    let fileName = "level\(levelNumber).plist"
    let levelPath = "\(Bundle.main.resourcePath!)/\(fileName)"
    let levelDictionary: NSDictionary? = NSDictionary(contentsOfFile: levelPath)
    assert(levelDictionary != nil, "Level configuration file not found")
    //self.pointsPerTile = levelDictionary!["pointsPerTile"] as! Int
    //self.timeToSolve = levelDictionary!["timeToSolve"] as! Int
    self.sentence = levelDictionary!["sentence"] as! [NSArray]
  }
}
