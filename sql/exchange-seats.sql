SELECT IF(`id` = (SELECT MAX(`id`) FROM `seat`) AND (`id` & 1), `id`, IF(`id` & 1, `id` + 1, `id` - 1)) AS `id`, `student` FROM `seat` ORDER BY `id`
