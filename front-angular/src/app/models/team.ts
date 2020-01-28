import { TeamRapportStats } from './team-rapports-stats';

export interface Team  {
    teamName: String,
    league: String;
    position: Number;
    positionH: Number;
    positionA: Number;
    teamRapportStats: TeamRapportStats;
  }