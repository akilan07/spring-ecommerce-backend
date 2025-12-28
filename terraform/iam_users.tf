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

resource "aws_iam_user" "cicd_user" {
  name = "cicd-user"
}

resource "aws_iam_user_policy" "cicd_policy" {
  name = "cicd-policy"
  user = aws_iam_user.cicd_user.name

  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Effect = "Allow"
        Action = [
          "ecr:GetAuthorizationToken",
          "ecr:BatchCheckLayerAvailability",
          "ecr:PutImage",
          "ecr:InitiateLayerUpload",
          "ecr:UploadLayerPart",
          "ecr:CompleteLayerUpload"
        ]
        Resource = "*"
      },
      {
        Effect = "Allow"
        Action = [
          "ec2:DescribeInstances"
        ]
        Resource = "*"
      },
      {
        Effect = "Allow"
        Action = [
          "ssm:StartSession"
        ]
        Resource = "*"
      }
    ]
  })
}