resource "aws_iam_user" "ecr_admin" {
  name = "ecr-admin"
}

resource "aws_iam_user_policy_attachment" "ecr_admin_policy" {
  user       = aws_iam_user.ecr_admin.name
  policy_arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryFullAccess"
}

resource "aws_iam_user" "ec2_admin" {
  name = "ec2-admin"
}

resource "aws_iam_user_policy_attachment" "ec2_admin_policy" {
  user       = aws_iam_user.ec2_admin.name
  policy_arn = "arn:aws:iam::aws:policy/AmazonEC2FullAccess"
}