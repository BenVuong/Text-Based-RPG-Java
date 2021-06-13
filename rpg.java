import java.util.Random;
import java.util.Scanner;


public class TextBasedRPG
{
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        final Random rand = new Random();
        final String[] enemies1 = { "Skeleton", "Zombie", "Goblin", "Kobold", "Twig Blight" };
        final String[] enemies2 = { "BugBear", "DireWolf", "Ghoul", "Bandit" };
        final String[] enemies3 = { "OwlBear", "Cultist", "Orc", "Nothic" };
        final int maxEnemyHealth = 75;
        final int enemyAttackDamage = 25;
        int levelUpToken2 = 0;
        int levelUpToken3 = 0;
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        final int healtPotionHealAmount = 30;
        final int healthPotionDropChance = 40;
        int exp = 0;
        int level = 1;
        int mana = 20;
        int stamina = 30;
        final int maxStamina = 30;
        final int chanceDodge = 30;
        final int chanceMiss = 40;
        int arrows = 10;
        final boolean running = true;
        System.out.println("");
        System.out.println("        ,     \\    /      ,        ");
        System.out.println("       / \\    )\\__/(     / \\       ");
        System.out.println("      /   \\  (_\\  /_)   /   \\      ");
        System.out.println(" ____/_____\\__\\@  @/___/_____\\____ ");
        System.out.println("|             |\\../|              |");
        System.out.println("|              \\VV/               |");
        System.out.println("|    Welcome a Text-Based RPG     |");
        System.out.println("|_________________________________|");
        System.out.println(" |    /\\ /      \\\\       \\ /\\    | ");
        System.out.println(" |  /   V        ))       V   \\  | ");
        System.out.println(" |/     `       //        '     \\| ");
        System.out.println(" `              V                '");
        System.out.println(" First Choose your character's Class");
        System.out.println("1.Barbarin\n2.Wizard\n3.Ranger\nEnter the number of the option to choose");
        final String Class = scan.nextLine();
        System.out.println("-------------------------");
        if (Class.equals("1")) {
            System.out.println("As a Barbarin you have high amount of health and deal lots of damage");
        }
        else if (Class.equals("2")) {
            System.out.println("As a wizard you can spend mana points to cast thest four spells");
            System.out.println("FireBall, LightingBolt, MagicMissle, and FlyingDaggers");
            health = 75;
        }
        else if (Class.equals("3")) {
            System.out.println("As a Ranger you can use your shortshort or bow to attack");
            System.out.println("If you use a bow to attack you have a 40% chance to miss but it deals 2x more damage than your short sword");
            System.out.println("Being a ranger you have high dexerity which means you have a 30% chance to dodge incoming attacks");
            health = 75;
        }
        else {
            System.out.println("Invalid Command\nRestart the game to try again");
            System.exit(0);
        }
        System.out.println("Welcome to the dungeon!");
        if (Class.equals("1")) {
        Label_1730:
            while (running) {
                System.out.println("-------------------------");
                if (exp < 300) {
                    System.out.println("You are now at Level: 1");
                    level = 1;
                }
                int enemyHealth = rand.nextInt(maxEnemyHealth);
                String enemy = enemies1[rand.nextInt(enemies1.length)];
                if (exp >= 300) {
                    if (++levelUpToken2 == 1) {
                        health = 125;
                        attackDamage = 70;
                        System.out.println("You have leveled up to level 2");
                        System.out.println("Your health is boosted to 125 and attack damage is boosted to 70");
                        numHealthPotions += 3;
                        System.out.println("As a reward for leveling up to level 2 you recieved 3 addtional Health potions");
                    }
                    enemy = enemies2[rand.nextInt(enemies2.length)];
                    enemyHealth = rand.nextInt(76) + 50;
                    level = 2;
                }
                if (exp >= 900) {
                    if (++levelUpToken3 == 1) {
                        health = 150;
                        attackDamage = 100;
                        System.out.println("You have leveled up to level 3");
                        System.out.println("Your health is boosted to 125 and attack damage is boosted to 100");
                        numHealthPotions += 3;
                        System.out.println("As a reward for leveling up to level 3 you recieved 3 addtional Health potions");
                    }
                    enemy = enemies3[rand.nextInt(enemies3.length)];
                    enemyHealth = rand.nextInt(76) + 75;
                    level = 3;
                }
                System.out.println("\t# " + enemy + " has appeared! #\n");
                while (enemyHealth > 0) {
                    System.out.println("\tYour Hp: " + health + " Stamina: " + stamina);
                    System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t1. Attack");
                    System.out.println("\t2. Drink health Potion");
                    System.out.println("\t3. Run!");
                    String input = scan.nextLine();
                    if (input.equals("1")) {
                        int damageDealt = rand.nextInt(attackDamage + 1 - 10) + 10;
                        final int damageTaken = rand.nextInt(enemyAttackDamage);
                        System.out.println("\t\t 1.Normal Attack");
                        System.out.println("\t\t 2.PowerAttack - deals 2X damage (costs 20 stamina)");
                        input = scan.nextLine();
                        if (input.equals("2")) {
                            if (stamina >= 20) {
                                damageDealt *= 2;
                                stamina -= 20;
                                System.out.println("You used PowerAttack dealing double damage");
                            }
                            else {
                                System.out.println("You dont have enough stamina to use PowerAttack so you use your normal attack");
                            }
                        }
                        enemyHealth -= damageDealt;
                        health -= damageTaken;
                        System.out.println("\t> you strike the " + enemy + " for " + damageDealt + " damage");
                        System.out.println("\t> you took " + damageTaken + " by the " + enemy);
                        System.out.println("-------------------------");
                        if (health < 1) {
                            System.out.println("");
                            System.out.println("#     #                  ######                  ### ");
                            System.out.println(" #   #   ####  #    #    #     # # ###### #####  ### ");
                            System.out.println("  # #   #    # #    #    #     # # #      #    # ### ");
                            System.out.println("   #    #    # #    #    #     # # #####  #    #  #  ");
                            System.out.println("   #    #    # #    #    #     # # #      #    #     ");
                            System.out.println("   #    #    # #    #    #     # # #      #    # ### ");
                            System.out.println("   #     ####   ####     ######  # ###### #####  ### ");
                            System.out.println("");
                            break;
                        }
                        continue;
                    }
                    else if (input.equals("2")) {
                        if (numHealthPotions > 0) {
                            health += healtPotionHealAmount;
                            --numHealthPotions;
                            System.out.println("\t> You drank a health Potion, healing you for " + healtPotionHealAmount);
                            System.out.println("\t> You now have " + health + " HP");
                            System.out.println("\t> You now have " + numHealthPotions + " health potions left");
                        }
                        else {
                            System.out.println("\t> You dont have any health potions left!");
                            System.out.println("\t> Kill this " + enemy + " to get more health potions");
                        }
                    }
                    else if (input.equals("3")) {
                        if (stamina > 1) {
                            stamina -= 10;
                            System.out.println("\tYou ran away from the " + enemy + " !");
                            continue Label_1730;
                        }
                        System.out.println("\tYou couldn't run away because you don't have enough stamina");
                    }
                    else {
                        System.out.println("\tInvalid Command!");
                    }
                }
                if (health < 1) {
                    System.out.println("");
                    break;
                }
                System.out.println("-------------------------");
                if (enemy.equals("Skeleton") || enemy.equals("Zombie") || enemy.equals("Goblin")) {
                    exp += 50;
                    System.out.println("You gained: 50 exp");
                }
                else if (enemy.equals("Kobold") || enemy.equals("Twig Blight")) {
                    exp += 25;
                    System.out.println("You gained: 25 exp");
                }
                else if (enemy.equals("BugBear") || enemy.equals("DireWolf") || enemy.equals("Ghoul") || enemy.equals("Bandit")) {
                    exp += 100;
                    System.out.println("You gained: 100 exp");
                }
                stamina += 10;
                System.out.println(" # " + enemy + " was killed! #");
                if (maxStamina > stamina) {
                    final int staminaRegain = 10;
                    stamina += staminaRegain - 10;
                    System.out.println("\t> You regain 10 stamina");
                }
                System.out.println(" # You have " + health + " HP");
                System.out.println(" # You are currently at level " + level + " and have: " + exp + " experience points");
                if (rand.nextInt(100) < healthPotionDropChance) {
                    ++numHealthPotions;
                    System.out.println(" # The " + enemy + " droppped a health potion! #");
                    System.out.println(" # you now have " + numHealthPotions + " health potion(s) ");
                }
                System.out.println("-------------------------");
                System.out.println("What would you like to do?");
                System.out.println("1. Continue Fighting");
                System.out.println("2. Exit the dungeon");
                String input;
                for (input = scan.nextLine(); !input.equals("1") && !input.equals("2"); input = scan.nextLine()) {
                    System.out.println("Invalid Command!");
                }
                if (!input.equals("1")) {
                    System.out.println("You exit the dungeon");
                    break;
                }
                System.out.println("You continue on your adventure!");
            }
        }
        else if (Class.equals("2")) {
        Label_3516:
            while (running) {
                System.out.println("-------------------------");
                if (exp < 300) {
                    System.out.println("You are now at Level: 1");
                    level = 1;
                }
                int enemyHealth = rand.nextInt(maxEnemyHealth);
                String enemy = enemies1[rand.nextInt(enemies1.length)];
                if (exp >= 300) {
                    if (++levelUpToken2 == 1) {
                        health = 125;
                        attackDamage = 70;
                        mana = 30;
                        final int maxMana = 30;
                        numHealthPotions += 3;
                        System.out.println("You have leveled up to level 2");
                        System.out.println("Your health is boosted to 125 and attack damage is boosted to 70");
                        System.out.println("Your Mana is boosted to 30");
                        System.out.println("As a reward for leveling up to level 2 you recieved 3 addtional Health potions");
                    }
                    System.out.println("You are now at Level: 2");
                    enemy = enemies2[rand.nextInt(enemies2.length)];
                    enemyHealth = rand.nextInt(76) + 50;
                    level = 2;
                }
                if (exp >= 900) {
                    if (++levelUpToken3 == 1) {
                        health = 150;
                        attackDamage = 100;
                        mana = 40;
                        final int maxMana = 40;
                        numHealthPotions += 3;
                        System.out.println("You have leveled up to level 3");
                        System.out.println("Your health is boosted to 125 and attack damage is boosted to 100");
                        System.out.println("Your Mana is boosted to 40");
                        System.out.println("As a reward for leveling up to level 3 you recieved 3 addtional Health potions");
                    }
                    System.out.println("You are now at Level: 3");
                    enemy = enemies3[rand.nextInt(enemies3.length)];
                    enemyHealth = rand.nextInt(101) + 100;
                    level = 3;
                }
                System.out.println("\t# " + enemy + " has appeared! #\n");
                while (enemyHealth > 0) {
                    System.out.println("\tYour Hp: " + health + " Mana: " + mana + " Stamina: " + stamina);
                    System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t1. Attack");
                    System.out.println("\t2. Drink health Potion");
                    System.out.println("\t3. Run!");
                    String input = scan.nextLine();
                    if (input.equals("1")) {
                        String spell = "a spell";
                        int min = 10;
                        System.out.println("\t Select a spell form your spell book to use");
                        System.out.println("\t\t1.FireBall: Cost 0 Mana (It is a cantrip spell) ");
                        System.out.println("\t\t2.LightingBolt: Cost 5 Mana ");
                        System.out.println("\t\t3.MagicMissle: Cost 10 Mana ");
                        System.out.println("\t\t4.FlyingDaggers: Cost 15 Mana ");
                        input = scan.nextLine();
                        if (input.equals("1")) {
                            spell = "FireBall";
                            attackDamage = 15;
                        }
                        else if (input.equals("2")) {
                            if (mana >= 5) {
                                attackDamage = 35;
                                mana -= 5;
                                spell = "LightingBolt";
                            }
                            else {
                                System.out.println("You dont have enough mana");
                                attackDamage = 0;
                                min = 0;
                            }
                        }
                        else if (input.equals("3")) {
                            if (mana >= 10) {
                                attackDamage = 50;
                                mana -= 10;
                                spell = "MagicMissle";
                            }
                            else {
                                System.out.println("You dont have enough mana");
                                attackDamage = 0;
                                min = 0;
                            }
                        }
                        else if (input.equals("4")) {
                            if (mana >= 15) {
                                attackDamage = 75;
                                mana -= 15;
                                spell = "FlyingDaggers";
                            }
                            else {
                                System.out.println("You dont have enough mana");
                                attackDamage = 0;
                                min = 0;
                            }
                        }
                        else {
                            System.out.println("Invalid Command");
                        }
                        int damageDealt2;
                        if (min == 0) {
                            damageDealt2 = 0;
                        }
                        else {
                            damageDealt2 = rand.nextInt(attackDamage + 1 - 10) + 10;
                        }
                        final int damageTaken2 = rand.nextInt(enemyAttackDamage);
                        if (min == 0) {
                            enemyHealth -= damageDealt2;
                            health -= damageTaken2;
                            System.out.println("\t> you tried casted " + spell + " but since you dont have enough mana nothing happend");
                            System.out.println("\t> you took " + damageTaken2 + " by the " + enemy);
                        }
                        else {
                            enemyHealth -= damageDealt2;
                            health -= damageTaken2;
                            System.out.println("\t> you casted " + spell + " hitting the " + enemy + " for " + damageDealt2 + " damage");
                            System.out.println("\t> you took " + damageTaken2 + " by the " + enemy);
                        }
                        if (health < 1) {
                            System.out.println("");
                            break;
                        }
                        continue;
                    }
                    else if (input.equals("2")) {
                        if (numHealthPotions > 0) {
                            health += healtPotionHealAmount;
                            --numHealthPotions;
                            System.out.println("\t> You drank a health Potion, healing you for " + healtPotionHealAmount);
                            System.out.println("\t> You now have " + health + " HP");
                            System.out.println("\t> You now have " + numHealthPotions + " health potions left");
                        }
                        else {
                            System.out.println("\t> You dont have any health potions left!");
                            System.out.println("\t> Kill this " + enemy + " to get more health potions");
                        }
                    }
                    else if (input.equals("3")) {
                        if (stamina > 1) {
                            stamina -= 10;
                            System.out.println("\tYou ran away from the " + enemy + " !");
                            final int maxMana = 20;
                            if (mana < maxMana) {
                                final int manaRegainPoint = rand.nextInt(10) + 1;
                                mana += manaRegainPoint;
                                System.out.println("\tAfter you ran away you took a short rest and regain: " + manaRegainPoint);
                                continue Label_3516;
                            }
                            System.out.println("You have reached your max mana amount");
                            continue Label_3516;
                        }
                        else {
                            System.out.println("\tYou couldn't run away because you don't have enough stamina");
                        }
                    }
                    else {
                        System.out.println("\tInvalid Command!");
                    }
                }
                if (health < 1) {
                    System.out.println("");
                    System.out.println("#     #                  ######                  ### ");
                    System.out.println(" #   #   ####  #    #    #     # # ###### #####  ### ");
                    System.out.println("  # #   #    # #    #    #     # # #      #    # ### ");
                    System.out.println("   #    #    # #    #    #     # # #####  #    #  #  ");
                    System.out.println("   #    #    # #    #    #     # # #      #    #     ");
                    System.out.println("   #    #    # #    #    #     # # #      #    # ### ");
                    System.out.println("   #     ####   ####     ######  # ###### #####  ### ");
                    System.out.println("");
                    break;
                }
                System.out.println("-------------------------");
                if (enemy.equals("Skeleton") || enemy.equals("Zombie") || enemy.equals("Goblin")) {
                    exp += 50;
                    System.out.println("You gained: 50 exp");
                }
                else if (enemy.equals("Kobold") || enemy.equals("Twig Blight")) {
                    exp += 25;
                    System.out.println("You gained: 25 exp");
                }
                else if (enemy.equals("BugBear") || enemy.equals("DireWolf") || enemy.equals("Ghoul") || enemy.equals("Bandit")) {
                    exp += 100;
                    System.out.println("You gained: 100 exp");
                }
                System.out.println(" # " + enemy + " was killed! #");
                final int manaRegain = rand.nextInt(10) + 1;
                mana += manaRegain;
                if (maxStamina > stamina) {
                    final int wizStaminaRegain = 10;
                    stamina += wizStaminaRegain;
                    System.out.println("\t> You regain " + wizStaminaRegain + " stamina");
                }
                System.out.println("\t> You regain " + manaRegain + " mana points");
                System.out.println(" # You have " + health + " HP");
                System.out.println(" # You are currently at level " + level + " and have: " + exp + " experience points");
                if (rand.nextInt(100) < healthPotionDropChance) {
                    ++numHealthPotions;
                    System.out.println(" # The " + enemy + " droppped a health potion! #");
                    System.out.println(" # you now have " + numHealthPotions + " health potion(s) ");
                }
                System.out.println("-------------------------");
                System.out.println("What would you like to do?");
                System.out.println("1. Continue Fighting");
                System.out.println("2. Exit the dungeon");
                String input2;
                for (input2 = scan.nextLine(); !input2.equals("1") && !input2.equals("2"); input2 = scan.nextLine()) {
                    System.out.println("Invalid Command!");
                }
                if (!input2.equals("1")) {
                    System.out.println("You exit the dungeon");
                    break;
                }
                System.out.println("You continue on your adventure!");
            }
            System.out.println("-------------------------");
            System.out.println("THANKS FOR PLAYING!");
        }
        else if (Class.equals("3")) {
        Label_5048:
            while (running) {
                System.out.println("-------------------------");
                if (exp < 300) {
                    System.out.println("You are now at Level: 1");
                    level = 1;
                }
                int enemyHealth = rand.nextInt(maxEnemyHealth);
                String enemy = enemies1[rand.nextInt(enemies1.length)];
                if (exp >= 300) {
                    if (++levelUpToken2 == 1) {
                        health = 100;
                        attackDamage = 70;
                        System.out.println("You have leveled up to level 2");
                        System.out.println("Your health is boosted to 125 and attack damage is boosted to 70");
                        numHealthPotions += 3;
                        System.out.println("As a reward for leveling up to level 2 you recieved 3 addtional Health potions");
                    }
                    enemy = enemies2[rand.nextInt(enemies2.length)];
                    enemyHealth = rand.nextInt(76) + 50;
                    level = 2;
                }
                if (exp >= 900) {
                    if (++levelUpToken3 == 1) {
                        health = 150;
                        attackDamage = 100;
                        System.out.println("You have leveled up to level 3");
                        System.out.println("Your health is boosted to 150 and attack damage is boosted to 100");
                        numHealthPotions += 3;
                        System.out.println("As a reward for leveling up to level 3 you recieved 3 addtional Health potions");
                    }
                    enemy = enemies3[rand.nextInt(enemies3.length)];
                    enemyHealth = rand.nextInt(76) + 75;
                    level = 3;
                }
                System.out.println("\t# " + enemy + " has appeared! #\n");
                while (enemyHealth > 0) {
                    System.out.println("\tYour Hp: " + health + " Stamina: " + stamina + " Arrows: " + arrows);
                    System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t1. Attack");
                    System.out.println("\t2. Drink health Potion");
                    System.out.println("\t3. Run!");
                    String input = scan.nextLine();
                    if (input.equals("1")) {
                        int damageDealt = rand.nextInt(attackDamage + 1 - 10) + 10;
                        final int damageTaken = rand.nextInt(enemyAttackDamage);
                        System.out.println("\t\t 1.ShortSword");
                        System.out.println("\t\t 2.Use your Bow - deals 2X more damage than your shortsword (costs 1 arrow)");
                        input = scan.nextLine();
                        if (input.equals("2")) {
                            if (arrows >= 1) {
                                damageDealt *= 2;
                                --arrows;
                                if (rand.nextInt(100) > chanceMiss) {
                                    System.out.println("You used your Bow dealing double damage");
                                    damageDealt *= 2;
                                }
                                else {
                                    System.out.println("You missed");
                                    damageDealt -= damageDealt;
                                }
                            }
                            else {
                                System.out.println("You ran out of arrows so you use your shortsword instead");
                            }
                        }
                        if (rand.nextInt(100) > chanceDodge) {
                            enemyHealth -= damageDealt;
                            health -= damageTaken;
                            System.out.println("\t> you hit the " + enemy + " for " + damageDealt + " damage");
                            System.out.println("\t> you took " + damageTaken + " by the " + enemy);
                            System.out.println("-------------------------");
                        }
                        else {
                            enemyHealth -= damageDealt;
                            System.out.println("\t> you hit the " + enemy + " for " + damageDealt + " damage");
                            System.out.println("\t> you dodge the " + enemy + "'s attack and took no damage");
                            System.out.println("-------------------------");
                        }
                        if (health < 1) {
                            System.out.println("");
                            System.out.println("#     #                  ######                  ### ");
                            System.out.println(" #   #   ####  #    #    #     # # ###### #####  ### ");
                            System.out.println("  # #   #    # #    #    #     # # #      #    # ### ");
                            System.out.println("   #    #    # #    #    #     # # #####  #    #  #  ");
                            System.out.println("   #    #    # #    #    #     # # #      #    #     ");
                            System.out.println("   #    #    # #    #    #     # # #      #    # ### ");
                            System.out.println("   #     ####   ####     ######  # ###### #####  ### ");
                            System.out.println("");
                            break;
                        }
                        continue;
                    }
                    else if (input.equals("2")) {
                        if (numHealthPotions > 0) {
                            health += healtPotionHealAmount;
                            --numHealthPotions;
                            System.out.println("\t> You drank a health Potion, healing you for " + healtPotionHealAmount);
                            System.out.println("\t> You now have " + health + " HP");
                            System.out.println("\t> You now have " + numHealthPotions + " health potions left");
                        }
                        else {
                            System.out.println("\t> You dont have any health potions left!");
                            System.out.println("\t> Kill this " + enemy + " to get more health potions");
                        }
                    }
                    else if (input.equals("3")) {
                        if (stamina >= 10) {
                            stamina -= 10;
                            System.out.println("\tYou ran away from the " + enemy + " !");
                            continue Label_5048;
                        }
                        System.out.println("\tYou couldn't run away because you don't have enough stamina");
                    }
                    else {
                        System.out.println("\tInvalid Command!");
                    }
                }
                if (health < 1) {
                    System.out.println("");
                    break;
                }
                System.out.println("-------------------------");
                if (enemy.equals("Skeleton") || enemy.equals("Zombie") || enemy.equals("Goblin")) {
                    exp += 50;
                    System.out.println("You gained: 50 exp");
                }
                else if (enemy.equals("Kobold") || enemy.equals("Twig Blight")) {
                    exp += 25;
                    System.out.println("You gained: 25 exp");
                }
                else if (enemy.equals("BugBear") || enemy.equals("DireWolf") || enemy.equals("Ghoul") || enemy.equals("Bandit")) {
                    exp += 100;
                    System.out.println("You gained: 100 exp");
                }
                stamina += 10;
                System.out.println(" # " + enemy + " was killed! #");
                if (maxStamina < stamina) {
                    stamina -= 10;
                }
                final int chanceToGetArrows = 40;
                if (rand.nextInt(100) < chanceToGetArrows) {
                    final int arrowRegain = rand.nextInt(3) + 1;
                    arrows += arrowRegain;
                    System.out.println("\t> You regain " + arrowRegain + " arrow");
                }
                System.out.println(" # You have " + health + " HP");
                System.out.println(" # You are currently at level " + level + " and have: " + exp + " experience points");
                if (rand.nextInt(100) < healthPotionDropChance) {
                    ++numHealthPotions;
                    System.out.println(" # The " + enemy + " droppped a health potion! #");
                    System.out.println(" # you now have " + numHealthPotions + " health potion(s) ");
                }
                System.out.println("-------------------------");
                System.out.println("What would you like to do?");
                System.out.println("1. Continue Fighting");
                System.out.println("2. Exit the dungeon");
                String input2;
                for (input2 = scan.nextLine(); !input2.equals("1") && !input2.equals("2"); input2 = scan.nextLine()) {
                    System.out.println("Invalid Command!");
                }
                if (!input2.equals("1")) {
                    System.out.println("You exit the dungeon");
                    break;
                }
                System.out.println("You continue on your adventure!");
            }
        }
    }
}