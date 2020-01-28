import { Team } from './team'
import { CombinedRapport } from './combined-rapport'

export interface FixtureRapport {
    homeTeam:Team,
    awayTeam:Team,
    combinedRapport:CombinedRapport,
}
