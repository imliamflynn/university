//
//  GameData.swift
//  COSC345-Lang
//
//  Created by Ben Stacey on 16/08/22.
//
import Foundation

/**
    Stores the score of the player after each game
 */
public class GameData {
  //store the user's game achievement
  var points: Int = 0 {
    didSet { 
      points = max(points, 0)
    }
  }
}
