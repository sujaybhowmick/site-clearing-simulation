# Site Clearing Simulation

## Prequisites

Java 11 Runtime

## Run Tests

```bash
~/l/site-clearing-simulation$ ./gradlew clean check

BUILD SUCCESSFUL in 1s
5 actionable tasks: 5 executed
```

## Build Jar

```bash
~/l/site-clearing-simulation$ ./gradlew clean jar

BUILD SUCCESSFUL in 870ms
4 actionable tasks: 4 executed
```

## Run Simulation Program

```bash
 ~/l/site-clearing-simulation$ java -jar build/libs/site-clearing-simulation-1.0-SNAPSHOT.jar --file ./site-map-input.txt
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: r
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: l
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 2
(l)eft, (r)ight, (a)dvance <n>, (q)uit: a 4
(l)eft, (r)ight, (a)dvance <n>, (q)uit: l
(l)eft, (r)ight, (a)dvance <n>, (q)uit: q
advance 4, turn right, advance 4, turn left, advance 2, advance 4, turn left, quit
Item                                                     Quantity       Cost
Communication overhead                                       8          8
Fuel                                                         19         19
Uncleared square at end of Simulation                        34        102
Destruction of protected trees                               0          0
Repairing paint damage to bulldozer clearable tree           2          4
---------------------------------------------------------------------------
Total                                                                  133

Thank you for using Aconex site clearing simulator
```

